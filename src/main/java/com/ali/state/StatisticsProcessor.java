package com.ali.state;

public class StatisticsProcessor {
    private AbstractStatisticsState state;
    private String unit;
    public StatisticsProcessor() {
        state = new DayStatisticsState();
    }

    public void statistics() {
        state.statistics(this);
    }

    public AbstractStatisticsState getState() {
        return state;
    }

    public void setState(AbstractStatisticsState state) {
        this.state = state;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
