package com.incident.aiincidentinvestigators.agent;

import com.incident.aiincidentinvestigators.model.LogAnalysis;
import com.incident.aiincidentinvestigators.model.MetricAnalysis;
import com.incident.aiincidentinvestigators.model.RootCauseAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RootCauseAgent {

    private final ChatClient chatClient;

    public RootCauseAnalysis analyze(
            LogAnalysis logAnalysis,
            MetricAnalysis metricAnalysis) {

        String prompt = """
                You are a Senior Site Reliability Engineer.
                
                Log Analysis:
                Issue: %s
                Severity: %s
                Recommendation: %s
                
                Metric Analysis:
                Anomaly: %s
                Impact: %s
                Recommendation: %s
                
                Determine:
                1. Most likely root cause
                2. Confidence score (0.0 - 1.0)
                3. Recommended actions
                4. Executive summary
                
                Return structured output.
                """
                .formatted(
                        logAnalysis.issue(),
                        logAnalysis.severity(),
                        logAnalysis.recommendation(),
                        metricAnalysis.anomaly(),
                        metricAnalysis.impact(),
                        metricAnalysis.recommendation()
                );

        return chatClient.prompt()
                .user(prompt)
                .call()
                .entity(RootCauseAnalysis.class);
    }
}