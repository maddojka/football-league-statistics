package com.soroko.footballleaguestatistics.dto;

/**
 * @author yuriy.soroko
 */

public record TeamStatisticsDTO(
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
