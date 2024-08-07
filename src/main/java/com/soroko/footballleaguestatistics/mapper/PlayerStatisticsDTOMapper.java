package com.soroko.footballleaguestatistics.mapper;

import com.soroko.footballleaguestatistics.dto.PlayerStatisticsDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author yuriy.soroko
 */
@Service
public class PlayerStatisticsDTOMapper implements Function<PlayerStatistics, PlayerStatisticsDTO> {

    /**
     * This method represents playerStatistics form to playerStatisticsDto form
     * @param playerStatistics the function argument to convert
     * @return returns modified form
     */
    @Override
    public PlayerStatisticsDTO apply(PlayerStatistics playerStatistics) {
        return new PlayerStatisticsDTO(
                playerStatistics.getMatchesPlayed(),
                playerStatistics.getGoalsScored(),
                playerStatistics.getYellowCards(),
                playerStatistics.getRedCards(),
                playerStatistics.getSubmissions(),
                playerStatistics.getPlayer().getName() +
                        " " + playerStatistics.getPlayer().getSurname());
    }
}
