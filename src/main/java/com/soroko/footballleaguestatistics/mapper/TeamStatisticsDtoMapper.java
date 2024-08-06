package com.soroko.footballleaguestatistics.mapper;

import com.soroko.footballleaguestatistics.dto.TeamStatisticsDto;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author yuriy.soroko
 */
@Service
public class TeamStatisticsDtoMapper implements Function<TeamStatistics, TeamStatisticsDto> {
    @Override
    public TeamStatisticsDto apply(TeamStatistics teamStatistics) {
        return new TeamStatisticsDto(
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
