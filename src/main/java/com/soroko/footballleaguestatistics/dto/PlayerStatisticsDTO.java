package com.soroko.footballleaguestatistics.dto;

/**
 * @author yuriy.soroko
 */
public record PlayerStatisticsDTO(
        Integer matchesPlayed,
        Integer goalsScored,
        Integer yellowCards,
        Integer redCards,
        Integer submissions,
        String fullname
) {
}
