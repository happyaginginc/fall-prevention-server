package com.happyaging.fallprevention.survey.survey.entity;

import lombok.Getter;

@Getter
public enum RiskLevel {
    NONE(0), HIGH(1), MEDIUM(2), LOW(3);

    private final int level;

    RiskLevel(int level) {
        this.level = level;
    }

    public static RiskLevel fromInt(int dayNumber) {
        for (RiskLevel day : RiskLevel.values()) {
            if (day.getLevel() == dayNumber) {
                return day;
            }
        }
        return null;
    }
}
