package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.controller.feign.FootballLeagueClient;
import com.soroko.footballleaguestatistics.dto.TeamDto;
import com.soroko.footballleaguestatistics.dto.TeamStatisticsDto;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.service.TeamStatisticsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teamstat")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamStatisticsController {

    final TeamStatisticsService teamStatisticsService;

    FootballLeagueClient footballLeagueClient;

    @GetMapping("/all")
    public List<TeamStatisticsDto> getAllTeamStatisticsFromDB() {
        return teamStatisticsService.getAllTeamStatistics();
    }

    @GetMapping
    public ResponseEntity<TeamStatistics> getPlayerStatisticsByPlayer(@RequestParam TeamDto teamDTO) {

        var teamStatistics = teamStatisticsService.getTeamStatisticsByTeam(teamDTO);
        if (teamStatistics == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(teamStatistics, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public TeamStatistics addTeamStatistics(@RequestBody TeamStatistics teamStatistics, long id) {
        TeamDto teamDto = footballLeagueClient.getTeamDtoById(id);
        teamStatistics.setId(UUID.randomUUID());
        teamStatistics.setTeam(teamDto);
        return teamStatisticsService.saveTeamStatistics(teamStatistics);
    }
}
