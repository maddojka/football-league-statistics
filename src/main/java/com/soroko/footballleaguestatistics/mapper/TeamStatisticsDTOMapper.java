package com.soroko.footballleaguestatistics.mapper;

import com.soroko.footballleaguestatistics.dto.TeamStatisticsDTO;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author yuriy.soroko
 */
@Service
public class TeamStatisticsDTOMapper implements Function<TeamStatistics, TeamStatisticsDTO> {

    /**
     * This method represents teamStatistics form to teamStatisticsDto form
     * @param teamStatistics the function argument to convert
     * @return returns modified form
     */
    @Override
    public TeamStatisticsDTO apply(TeamStatistics teamStatistics) {
        return new TeamStatisticsDTO(
                teamStatistics.getPosition(),
                teamStatistics.getMatchesPlayed(),
                teamStatistics.getWins(),
                teamStatistics.getDefeats(),
                teamStatistics.getDraws(),
                teamStatistics.getGoalsFor(),
                teamStatistics.getGoalsAgainst(),
                teamStatistics.getGoalsDifference(),
                teamStatistics.getPoints(),
                teamStatistics.getTeam().getName());
    }
}
