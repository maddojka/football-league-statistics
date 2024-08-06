package com.soroko.footballleaguestatistics.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.PositiveOrZero;

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
