package com.soroko.footballleaguestatistics.dto;

import java.util.UUID;

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
