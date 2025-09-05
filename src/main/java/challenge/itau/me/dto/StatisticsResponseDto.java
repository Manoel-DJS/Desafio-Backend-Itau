package challenge.itau.me.dto;

import java.util.DoubleSummaryStatistics;

public record StatisticsResponseDto(
        Long count,
        double avg,
        double sum,
        double min,
        double max
) {
    public StatisticsResponseDto (DoubleSummaryStatistics statistics){
        this(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax()
        );
    }
}
