package com.dyvak.crm.configuration;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class ProfileNeededFailureAnalyzer implements FailureAnalyzer {
    @Override
    public FailureAnalysis analyze(Throwable failure) {
        if (failure.getMessage().contains("Should have production profile")) {
            return new FailureAnalysis("Should have production profile", "add --spring.profiles.active=production", failure);
        }
        return null;
    }
}
