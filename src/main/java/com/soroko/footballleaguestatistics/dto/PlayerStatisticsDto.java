package com.soroko.footballleaguestatistics.dto;

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
