package com.richardbreslin.westeam.repository;

import com.richardbreslin.westeam.entity.SteamAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WesteamRepository extends JpaRepository<SteamAppEntity, String> {
    List<SteamAppEntity> findByDetailsIsNullOrDetailsIs(String details);

    List<SteamAppEntity> findTop100ByDetailsIsNullOrDetailsIs(String empty);

    List<SteamAppEntity> findTop5ByDetailsIsNullOrDetailsIs(String empty);

    List<SteamAppEntity> findTop198ByDetailsIsNullOrDetailsIs(String empty);

}
