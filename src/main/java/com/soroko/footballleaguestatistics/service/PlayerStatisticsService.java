package com.soroko.footballleaguestatistics.service;

import com.soroko.footballleaguestatistics.dto.PlayerDto;
import com.soroko.footballleaguestatistics.dto.PlayerStatisticsDto;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.mapper.PlayerStatisticsDtoMapper;
import com.soroko.footballleaguestatistics.repository.PlayerStatisticsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerStatisticsService {
    final PlayerStatisticsRepository playerStatisticsRepository;
    final PlayerStatisticsDtoMapper playerStatisticsDtoMapper;

    public List<PlayerStatisticsDto> getAllPlayerStatistics() {
        return playerStatisticsRepository.findAll()
                .stream()
                .map(playerStatisticsDtoMapper)
                .collect(Collectors.toList());
    }


    public PlayerStatistics getPlayerStatisticsByPlayer(PlayerDto playerDTO) {
        return playerStatisticsRepository.findByPlayer(playerDTO);
    }

    public PlayerStatistics savePlayerStatistics(PlayerStatistics playerStatistics) {
        return playerStatisticsRepository.save(playerStatistics);
    }
}
