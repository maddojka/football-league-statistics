package com.soroko.footballleaguestatistics.service;

import com.soroko.footballleaguestatistics.dto.PlayerDTO;
import com.soroko.footballleaguestatistics.dto.PlayerStatisticsDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.mapper.PlayerStatisticsDTOMapper;
import com.soroko.footballleaguestatistics.repository.PlayerStatisticsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerStatisticsService {
    final PlayerStatisticsRepository playerStatisticsRepository;
    final PlayerStatisticsDTOMapper playerStatisticsDtoMapper;

    public List<PlayerStatisticsDTO> getAllPlayerStatistics() {
        return playerStatisticsRepository.findAll()
                .stream()
                .map(playerStatisticsDtoMapper)
                .collect(Collectors.toList());
    }


    public PlayerStatistics getPlayerStatisticsByPlayer(PlayerDTO playerDTO) {
        return playerStatisticsRepository.findByPlayer(playerDTO);
    }

    public PlayerStatistics savePlayerStatistics(PlayerStatistics playerStatistics) {
        return playerStatisticsRepository.save(playerStatistics);
    }
}
