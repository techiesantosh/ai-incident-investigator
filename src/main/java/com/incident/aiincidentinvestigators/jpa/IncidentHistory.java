package com.incident.aiincidentinvestigators.jpa;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incident_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String alert;

    @Column(columnDefinition = "TEXT")
    private String rootCause;

    private Double confidence;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private LocalDateTime createdAt;
}