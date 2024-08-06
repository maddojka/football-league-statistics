package com.soroko.footballleaguestatistics.mapper;

import com.soroko.footballleaguestatistics.dto.PlayerStatisticsDto;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author yuriy.soroko
 */
@Service
public class PlayerStatisticsDtoMapper implements Function<PlayerStatistics, PlayerStatisticsDto> {
    @Override
    public PlayerStatisticsDto apply(PlayerStatistics playerStatistics) {
        return new PlayerStatisticsDto(
                playerStatistics.getMatchesPlayed(),
                playerStatistics.getGoalsScored(),
                playerStatistics.getYellowCards(),
                playerStatistics.getRedCards(),
                playerStatistics.getSubmissions(),
                playerStatistics.getPlayer().getName() +
                        " " + playerStatistics.getPlayer().getSurname());
    }
}
