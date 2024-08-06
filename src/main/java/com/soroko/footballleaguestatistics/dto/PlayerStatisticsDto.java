package com.soroko.footballleaguestatistics.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * @author yuriy.soroko
 */
public record PlayerStatisticsDto(
        Integer matchesPlayed,
        Integer goalsScored,
        Integer yellowCards,
        Integer redCards,
        Integer submissions,
        String fullname
) {
}
