package com.soroko.footballleaguestatistics.service;

import com.soroko.footballleaguestatistics.dto.PlayerDto;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
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

    public PlayerStatistics getPlayerStatisticsByPlayer(PlayerDto playerDTO) {
        return playerStatisticsRepository.findByPlayer(playerDTO);
    }

    public PlayerStatistics savePlayerStatistics(PlayerStatistics playerStatistics) {
        return playerStatisticsRepository.save(playerStatistics);
    }
}
