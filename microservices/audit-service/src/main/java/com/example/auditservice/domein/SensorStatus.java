package com.example.auditservice.domein;

public enum SensorStatus {
    NORMAL(30), LOADED(60), FAILED(100);

    private final int maxValue;

    SensorStatus(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
