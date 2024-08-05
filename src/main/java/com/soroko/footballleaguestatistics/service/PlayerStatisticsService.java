package com.soroko.footballleaguestatistics.service;

import com.soroko.footballleaguestatistics.entity.PlayerDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.repository.PlayerStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerStatisticsService {
    private final PlayerStatisticsRepository playerStatisticsRepository;

    public List<PlayerStatistics> getAllPlayerStatistics() {
        return playerStatisticsRepository.findAll();
    }

    public PlayerStatistics getPlayerStatisticsByPlayer(PlayerDTO playerDTO) {
        return playerStatisticsRepository.findByPlayerDTO(playerDTO);
    }

    public PlayerStatistics savePlayerStatistics(PlayerStatistics playerStatistics) {
       return playerStatisticsRepository.save(playerStatistics);
    }
}
