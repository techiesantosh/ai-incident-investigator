package com.incident.aiincidentinvestigators.model;

public record LogAnalysis(
        String issue,
        String severity,
        String recommendation) {
}