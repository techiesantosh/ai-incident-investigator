package com.incident.aiincidentinvestigators.service;

import com.incident.aiincidentinvestigators.model.LogAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogAgent {

    private final ChatClient chatClient;

    public LogAnalysis analyze(List<String> logs) {

        String prompt = """
                Analyze these logs.
                Identify failures, patterns and probable causes.
                
                Logs:
                %s
                """.formatted(logs);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .entity(LogAnalysis.class);
    }
}