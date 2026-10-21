package com.incident.aiincidentinvestigators.service;


import com.incident.aiincidentinvestigators.agent.MetricsAgent;
import com.incident.aiincidentinvestigators.agent.RootCauseAgent;
import com.incident.aiincidentinvestigators.jpa.IncidentHistory;
import com.incident.aiincidentinvestigators.model.IncidentRequest;
import com.incident.aiincidentinvestigators.model.IncidentResponse;
import com.incident.aiincidentinvestigators.model.LogAnalysis;
import com.incident.aiincidentinvestigators.model.MetricAnalysis;
import com.incident.aiincidentinvestigators.model.RootCauseAnalysis;
import com.incident.aiincidentinvestigators.repository.IncidentHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final LogAgent logAgent;
    private final MetricsAgent metricsAgent;
    private final RootCauseAgent rootCauseAgent;
    private final IncidentHistoryRepository historyRepository;

    public IncidentResponse analyze(
            IncidentRequest request) {

        LogAnalysis logAnalysis =
                logAgent.analyze(request.getLogs());

        MetricAnalysis metricAnalysis =
                metricsAgent.analyze(request.getMetrics());

        RootCauseAnalysis rca =
                rootCauseAgent.analyze(
                        logAnalysis,
                        metricAnalysis);

        IncidentHistory history =
                IncidentHistory.builder()
                        .alert(request.getAlert())
                        .rootCause(rca.rootCause())
                        .confidence(rca.confidence())
                        .summary(rca.summary())
                        .createdAt(LocalDateTime.now())
                        .build();

        historyRepository.save(history);

        return IncidentResponse.builder()
                .rootCause(rca.rootCause())
                .confidence(rca.confidence())
                .recommendations(rca.recommendations())
                .summary(rca.summary())
                .build();
    }
}