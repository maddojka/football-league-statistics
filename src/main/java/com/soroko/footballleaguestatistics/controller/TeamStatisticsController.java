package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.controller.feign.FootballLeagueClient;
import com.soroko.footballleaguestatistics.dto.TeamDTO;
import com.soroko.footballleaguestatistics.dto.TeamStatisticsDTO;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.service.TeamStatisticsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teamstat")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamStatisticsController {

    final TeamStatisticsService teamStatisticsService;

    FootballLeagueClient footballLeagueClient;

    /**
     * Get all teams statistics from database
     * @return returns list of all modified teams statistics by mapper
     */
    @GetMapping("/all")
    public List<TeamStatisticsDTO> getAllTeamStatisticsFromDB() {
        return teamStatisticsService.getAllTeamStatistics();
    }

    /**
     * Get team statistics by team
     * @param teamDTO - form of team data transfer object
     * @return returns team statistics data
     */
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

    /**
     * Add team statistics to database
     * @param teamStatistics - statistics you need to add in database
     * @param id - id of the team
     * @return - returns team statistics
     */
    @PostMapping
    public TeamStatistics addTeamStatistics(@RequestBody TeamStatistics teamStatistics, Long id) {
        TeamDTO teamDto = footballLeagueClient.getTeamDtoById(id);
        teamStatistics.setId(UUID.randomUUID());
        teamStatistics.setTeam(teamDto);
        log.info("Add team statistics : {}", teamStatistics);
        return teamStatisticsService.saveTeamStatistics(teamStatistics);
    }
}
