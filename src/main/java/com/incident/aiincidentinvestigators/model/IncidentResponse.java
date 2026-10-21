package com.incident.aiincidentinvestigators.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IncidentResponse {

    private String rootCause;

    private Double confidence;

    private List<String> recommendations;

    private String summary;
}