package com.example.workflow.insulin;

import org.apache.commons.lang3.RandomUtils;

public final class InsulinGenerator {
    public static final int getInsulinValue(int patientId) {
        return RandomUtils.nextInt(1, 100);
    }
}
