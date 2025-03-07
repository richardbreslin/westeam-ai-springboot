package com.richardbreslin.westeam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.richardbreslin.westeam.data.SteamAppList;
import com.richardbreslin.westeam.entity.SteamAppEntity;
import com.richardbreslin.westeam.repository.WesteamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Slf4j
@Service
public class ScheduledTaskService {

    @Autowired
    private SteamService steamService;

    @Autowired
    private WesteamRepository westeamRepository;


   @Scheduled(fixedDelay = 300000) // Runs every 5 minutes
    public void updateSteamAppDetails() throws InterruptedException {
        System.out.println("Updating app details");
       Pageable pageable = PageRequest.of(0, 199);
        List<SteamAppEntity> apps = westeamRepository.findDetailsIsNull("", pageable);
        if (apps.isEmpty()) {
            log.info("No apps to update");
            return;
        }

        List<SteamAppEntity> updatedDetails = new ArrayList<>();

       for (SteamAppEntity app : apps) {
           ResponseEntity<String> details = steamService.getSteamAppDetails(app.getAppid());

           if (!details.getStatusCode().is2xxSuccessful()) {
               log.info("Failed to fetch details for: {} | Rate Limit likely reached.", app.getAppid());
               break;
           } else {
               if (details.getBody() != null) {
                   log.info("Updating: {}", app.getAppid());
                   app.setDetails(details.getBody().replaceAll("\\s+", ""));
                   app.setUpdatedAt(LocalDateTime.now());
                   app.setCreatedAt(LocalDateTime.now());
                   updatedDetails.add(app);
               }
               sleep(300);
           }
       }

        westeamRepository.saveAll(updatedDetails);
        log.info("Finished updating {} app details", updatedDetails.size());
    }

    @Scheduled(cron = "0 0 3 * * *") // Runs every day at 3am
    public void insertNewSteamApps() throws JsonProcessingException {
        long durationStartTime = System.currentTimeMillis();
        log.info("Finding new apps to store locally");
        List<String> localAppsFound = westeamRepository.findAllAppids();
        Set<String> localAppsSet = new HashSet<>(localAppsFound);
        SteamAppList appsFromApi = steamService.getSteamAppList();
        List<SteamAppEntity> insertedApps = new ArrayList<>();

        if (appsFromApi != null) {
            appsFromApi.getAppList().getApps().parallelStream()
                    .filter(app -> !localAppsSet.contains(String.valueOf(app.getAppid())))
                    .forEach(app -> {
                        SteamAppEntity entity = SteamAppEntity.builder()
                                .appid(String.valueOf(app.getAppid()))
                                .name(app.getName())
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build();
                        synchronized (insertedApps) {
                            insertedApps.add(entity);
                        }
                    });
        } else {
            log.error("Failed to fetch apps from Steam API");
        }

        if (insertedApps.isEmpty()) {
            log.info("No new apps found");
            return;
        }

        long durationEndTime = System.currentTimeMillis();
        westeamRepository.saveAll(insertedApps);
        log.info("Finished inserting {} new apps in {}", insertedApps.size(), humanReadableDuration(durationEndTime - durationStartTime));
    }

    private String humanReadableDuration(long duration) {
        return String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
    }


}
