package com.soroko.footballleaguestatistics.dto;

import java.util.UUID;

/**
 * @author yuriy.soroko
 */

public record TeamStatisticsDto(
        String position,
        Integer matchesPlayed,
        Integer wins,
        Integer defeats,
        Integer draws,
        Integer goalsFor,
        Integer goalsAgainst,
        Integer goalsDifference,
        Integer points,
        String teamName
) {
}
