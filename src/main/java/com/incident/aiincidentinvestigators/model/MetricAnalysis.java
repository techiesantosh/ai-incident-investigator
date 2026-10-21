package com.incident.aiincidentinvestigators.model;


public record MetricAnalysis(
        String anomaly,
        String impact,
        String recommendation
) {
}
