package com.incident.aiincidentinvestigators.repository;


import com.incident.aiincidentinvestigators.jpa.IncidentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentHistoryRepository
        extends JpaRepository<IncidentHistory, Long> {
}