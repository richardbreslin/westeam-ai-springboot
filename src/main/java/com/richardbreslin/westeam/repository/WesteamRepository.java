package com.richardbreslin.westeam.repository;

import com.richardbreslin.westeam.entity.SteamAppEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WesteamRepository extends JpaRepository<SteamAppEntity, String> {

    @Query("SELECT s FROM SteamAppEntity s WHERE s.details IS NULL OR s.details = :empty")
    List<SteamAppEntity> findDetailsIsNull(@Param("empty") String empty, @Param("limit") Pageable pageable);


    @Query("SELECT appid FROM SteamAppEntity")
    List<String> findAllAppids();

}
