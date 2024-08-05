package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.controller.feign.FootballLeagueClient;
import com.soroko.footballleaguestatistics.entity.PlayerDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.service.PlayerStatisticsService;
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
@RequestMapping("/api/playerstat")
public class PlayerStatisticsController {
    PlayerStatisticsService playerStatisticsService;
    FootballLeagueClient footballLeagueClient;

    @GetMapping("/all")
    public List<PlayerStatistics> getAllPlayerStatisticsFromDB() {
        return playerStatisticsService.getAllPlayerStatistics();
    }

    @GetMapping
    public ResponseEntity<PlayerStatistics> getPlayerStatisticsByPlayer(@RequestParam PlayerDTO playerDTO) {

        var playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayer(playerDTO);
        if (playerStatistics == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(playerStatistics, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public PlayerStatistics addPlayerStatistics(@RequestBody PlayerStatistics playerStatistics, int id) {
        PlayerDTO playerDto = footballLeagueClient.getPlayerById(id);
        playerStatistics.setId(UUID.randomUUID());
        playerStatistics.setPlayer(playerDto);
        return playerStatisticsService.savePlayerStatistics(playerStatistics);
    }
}
