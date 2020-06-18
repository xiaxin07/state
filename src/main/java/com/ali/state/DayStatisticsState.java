package com.ali.state;

import com.ali.mapper.DayMapper;

public class DayStatisticsState extends AbstractStatisticsState {
    DayMapper dayMapper = new DayMapper();
    @Override
    public void statistics(StatisticsProcessor statisticsProcessor) {
        if ("Day".equals(statisticsProcessor.getUnit())) {
            dayMapper.select();
        } else {
            statisticsProcessor.setState(new WeekStatisticsState());
            statisticsProcessor.statistics();
        }
    }
}
