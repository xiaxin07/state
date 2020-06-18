package com.ali.state;

import com.ali.mapper.MonthMapper;

public class MonthStatisticsState extends AbstractStatisticsState{

    private MonthMapper monthMapper = new MonthMapper();

    @Override
    public void statistics(StatisticsProcessor statisticsProcessor) {
        if ("Month".equals(statisticsProcessor.getUnit())) {
            monthMapper.select();
        } else {
            statisticsProcessor.setState(new WeekStatisticsState());
            statisticsProcessor.statistics();
        }
    }
}
