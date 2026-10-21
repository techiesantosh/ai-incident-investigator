package com.incident.aiincidentinvestigators.service;


import java.util.List;

public record RootCauseAnalysis(
        String rootCause,
        Double confidence,
        List<String> recommendations,
        String summary
) {
}