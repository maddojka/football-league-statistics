package com.soroko.footballleaguestatistics.service;


import com.soroko.footballleaguestatistics.entity.PlayerDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.entity.TeamDTO;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.repository.TeamStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamStatisticsService {

    private TeamStatisticsRepository teamStatisticsRepository;

    public List<TeamStatistics> getAllTeamStatistics() {
        return teamStatisticsRepository.findAll();
    }

    public TeamStatistics getTeamStatisticsByTeam(TeamDTO teamDTO) {
        return teamStatisticsRepository.findByTeamDTO(teamDTO);
    }

    public TeamStatistics saveTeamStatistics(TeamStatistics teamStatistics) {
        return teamStatisticsRepository.save(teamStatistics);
    }

}
