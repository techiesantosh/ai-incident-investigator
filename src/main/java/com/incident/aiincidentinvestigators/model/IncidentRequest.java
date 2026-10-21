package com.incident.aiincidentinvestigators.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class IncidentRequest {

    private String alert;

    private List<String> logs;

    private Map<String, Object> metrics;
}