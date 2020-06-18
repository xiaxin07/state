package com.ali.test;

import com.ali.state.StatisticsProcessor;

public class Main {
    public static void main(String[] args) {
        StatisticsProcessor statisticsProcessor = new StatisticsProcessor();
        statisticsProcessor.setUnit("Week");
        statisticsProcessor.statistics();
    }
}
