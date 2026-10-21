package com.incident.aiincidentinvestigators.model;


import java.util.List;

public record RootCauseAnalysis(
        String rootCause,
        Double confidence,
        List<String> recommendations,
        String summary
) {
}