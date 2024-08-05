package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.entity.TeamDTO;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.service.TeamStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teamstat")
public class TeamStatisticsController {
    TeamStatisticsService teamStatisticsService;

    @GetMapping("/all")
    public List<TeamStatistics> getAllTeamStatisticsFromDB() {
        return teamStatisticsService.getAllTeamStatistics();
    }

    @GetMapping
    public ResponseEntity<TeamStatistics> getPlayerStatisticsByPlayer(@RequestParam TeamDTO teamDTO) {

        var teamStatistics = teamStatisticsService.getTeamStatisticsByTeam(teamDTO);
        if (teamStatistics == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(teamStatistics, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public TeamStatistics addTeamStatistics(@RequestBody TeamStatistics teamStatistics, TeamDTO teamDTO) {
        teamStatistics.setId(UUID.randomUUID());
        return teamStatisticsService.saveTeamStatistics(teamStatistics);
    }
}
