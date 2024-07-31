package com.soroko.footballleaguestatistics.service;

import com.soroko.footballleaguestatistics.repository.PlayerStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerStatisticsService {
    private final PlayerStatisticsRepository playerStatisticsRepository;

}
