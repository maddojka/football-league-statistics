package com.soroko.footballleaguestatistics.service;


import com.soroko.footballleaguestatistics.dto.TeamDto;
import com.soroko.footballleaguestatistics.dto.TeamStatisticsDto;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.mapper.TeamStatisticsDtoMapper;
import com.soroko.footballleaguestatistics.repository.TeamStatisticsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamStatisticsService {

    final TeamStatisticsRepository teamStatisticsRepository;
    private final TeamStatisticsDtoMapper teamStatisticsDtoMapper;

    public List<TeamStatisticsDto> getAllTeamStatistics() {
        return teamStatisticsRepository.findAll()
                .stream()
                .map(teamStatisticsDtoMapper)
                .collect(Collectors.toList());
    }

    public TeamStatistics getTeamStatisticsByTeam(TeamDto teamDTO) {
        return teamStatisticsRepository.findByTeam(teamDTO);
    }

    public TeamStatistics saveTeamStatistics(TeamStatistics teamStatistics) {
        return teamStatisticsRepository.save(teamStatistics);
    }

}
