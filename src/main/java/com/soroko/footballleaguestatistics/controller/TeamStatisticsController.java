package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.service.TeamStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TeamStatisticsController {
    TeamStatisticsService teamStatisticsService;


}
