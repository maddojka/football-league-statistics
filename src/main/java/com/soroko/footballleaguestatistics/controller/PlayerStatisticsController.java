package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.controller.feign.FootballLeagueClient;
import com.soroko.footballleaguestatistics.dto.PlayerDto;
import com.soroko.footballleaguestatistics.dto.PlayerStatisticsDto;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.service.PlayerStatisticsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerStatisticsController {

    final PlayerStatisticsService playerStatisticsService;
    final FootballLeagueClient footballLeagueClient;

    @GetMapping("/all")
    public List<PlayerStatisticsDto> getAllPlayerStatisticsFromDB() {
        return playerStatisticsService.getAllPlayerStatistics();
    }

    @GetMapping
    public ResponseEntity<PlayerStatistics> getPlayerStatisticsByPlayer(@RequestParam PlayerDto playerDTO) {
        var playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayer(playerDTO);
        if (playerStatistics == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(playerStatistics, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public PlayerStatistics addPlayerStatistics(@RequestBody PlayerStatistics playerStatistics, long id) {
        PlayerDto playerDTO = footballLeagueClient.getPlayerDtoById(id);
        playerStatistics.setId(UUID.randomUUID());
        playerStatistics.setPlayer(playerDTO);
        return playerStatisticsService.savePlayerStatistics(playerStatistics);
    }
}
