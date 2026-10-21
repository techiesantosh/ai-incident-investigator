package com.incident.aiincidentinvestigators.agent;

import com.incident.aiincidentinvestigators.model.MetricAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MetricsAgent {

    private final ChatClient chatClient;

    public MetricAnalysis analyze(Map<String, Object> metrics) {

        String prompt = """
                Analyze the following infrastructure metrics.
                
                Metrics:
                %s
                
                Identify:
                - anomalies
                - impact
                - recommendation
                
                Return structured output.
                """.formatted(metrics);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .entity(MetricAnalysis.class);
    }
}