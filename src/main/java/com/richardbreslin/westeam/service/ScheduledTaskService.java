package com.richardbreslin.westeam.service;

import com.richardbreslin.westeam.entity.SteamAppEntity;
import com.richardbreslin.westeam.repository.WesteamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

//@Service
//public class ScheduledTaskService {
//
//    @Autowired
//    private LocalSteamAppIDService localSteamAppIDService;
//
//    @Autowired
//    private SteamService steamService;
//
//    @Autowired
//    private WesteamRepository westeamRepository;
//
//
//    @Scheduled(fixedDelay = 300000) // Runs every 5 minutes
//    public void updateSteamAppDetails() throws InterruptedException {
//        System.out.println("Updating app details");
//        List<SteamAppEntity> apps = westeamRepository.findTop198ByDetailsIsNullOrDetailsIs("");
//        if (apps.isEmpty()) {
//            System.out.println("No apps to update");
//            return;
//        }
//
//        List<SteamAppEntity> updatedDetails = new ArrayList<>();
//
//        for (SteamAppEntity app : apps) {
//            String details = steamService.getSteamAppDetails(app.getAppid());
//            System.out.println("Updating: " + app.getAppid());
//            if (details != null) {
//                app.setDetails(details.replaceAll("\\s+", ""));
//                app.setUpdatedAt(LocalDateTime.now());
//                app.setCreatedAt(LocalDateTime.now());
//
//                updatedDetails.add(app);
//            }
//            sleep(300);
//        }
//
//        westeamRepository.saveAll(updatedDetails);
//        System.out.println("Finished updating app details");
//    }
//
//
//}
