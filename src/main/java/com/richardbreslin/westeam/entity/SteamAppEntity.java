package com.richardbreslin.westeam.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SteamAppEntity {

    @Id
    @Column(columnDefinition = "TEXT")
    private String appid;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String details;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
