package com.incident.aiincidentinvestigators.controller;

import com.incident.aiincidentinvestigators.model.IncidentRequest;
import com.incident.aiincidentinvestigators.model.IncidentResponse;
import com.incident.aiincidentinvestigators.service.IncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService service;

    @PostMapping("/analyze")
    public IncidentResponse analyze(
            @RequestBody IncidentRequest request) {

        return service.analyze(request);
    }
}