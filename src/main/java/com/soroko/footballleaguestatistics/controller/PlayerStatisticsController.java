package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.controller.feign.FootballLeagueClient;
import com.soroko.footballleaguestatistics.dto.PlayerDTO;
import com.soroko.footballleaguestatistics.dto.PlayerStatisticsDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.service.PlayerStatisticsService;
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
@RequestMapping("/api/playerstat")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerStatisticsController {

    final PlayerStatisticsService playerStatisticsService;
    final FootballLeagueClient footballLeagueClient;

    /**
     * Get all players statistics from database
     * @return returns list of all modified players statistics by mapper
     */
    @GetMapping("/all")
    public List<PlayerStatisticsDTO> getAllPlayerStatisticsFromDB() {
        return playerStatisticsService.getAllPlayerStatistics();
    }

    /**
     * Get player statistics by player
     * @param playerDTO - form of player data transfer object
     * @return returns player statistics data
     */
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

    /**
     * Add player statistics to database
     * @param playerStatistics - statistics you need to add in database
     * @param id - id of the player
     * @return - returns player statistics
     */
    @PostMapping
    public PlayerStatistics addPlayerStatistics(@RequestBody PlayerStatistics playerStatistics, Long id) {
        PlayerDTO playerDTO = footballLeagueClient.getPlayerDtoById(id);
        playerStatistics.setId(UUID.randomUUID());
        playerStatistics.setPlayer(playerDTO);
        log.info("Add player statistics : {}", playerStatistics);
        return playerStatisticsService.savePlayerStatistics(playerStatistics);
    }
}
