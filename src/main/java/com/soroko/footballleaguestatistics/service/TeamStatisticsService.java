package com.soroko.footballleaguestatistics.service;


import com.soroko.footballleaguestatistics.repository.TeamStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamStatisticsService {

    private TeamStatisticsRepository teamStatisticsRepository;

}
