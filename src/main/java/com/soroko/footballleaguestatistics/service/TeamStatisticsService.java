package com.soroko.footballleaguestatistics.service;


import com.soroko.footballleaguestatistics.dto.TeamDTO;
import com.soroko.footballleaguestatistics.dto.TeamStatisticsDTO;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.mapper.TeamStatisticsDTOMapper;
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
    private final TeamStatisticsDTOMapper teamStatisticsDtoMapper;

    public List<TeamStatisticsDTO> getAllTeamStatistics() {
        return teamStatisticsRepository.findAll()
                .stream()
                .map(teamStatisticsDtoMapper)
                .collect(Collectors.toList());
    }

    public TeamStatistics getTeamStatisticsByTeam(TeamDTO teamDTO) {
        return teamStatisticsRepository.findByTeam(teamDTO);
    }

    public TeamStatistics saveTeamStatistics(TeamStatistics teamStatistics) {
        return teamStatisticsRepository.save(teamStatistics);
    }

}
