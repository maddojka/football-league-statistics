package com.soroko.footballleaguestatistics.service;


import com.soroko.footballleaguestatistics.dto.TeamDTO;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.repository.TeamStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamStatisticsService {

    private final TeamStatisticsRepository teamStatisticsRepository;

    public List<TeamStatistics> getAllTeamStatistics() {
        return teamStatisticsRepository.findAll();
    }

    public TeamStatistics getTeamStatisticsByTeam(TeamDTO teamDTO) {
        return teamStatisticsRepository.findByTeam(teamDTO);
    }

    public TeamStatistics saveTeamStatistics(TeamStatistics teamStatistics) {
        return teamStatisticsRepository.save(teamStatistics);
    }

}
