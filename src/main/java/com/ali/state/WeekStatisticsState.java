package com.ali.state;

import com.ali.mapper.WeekMapper;

public class WeekStatisticsState extends AbstractStatisticsState {
    WeekMapper weekMapper = new WeekMapper();
    @Override
    public void statistics(StatisticsProcessor statisticsProcessor) {
        if ("Week".equals(statisticsProcessor.getUnit())) {
            weekMapper.select();
        } else {
            statisticsProcessor.setState(new WeekStatisticsState());
            statisticsProcessor.statistics();
        }

    }
}
