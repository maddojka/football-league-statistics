package com.soroko.footballleaguestatistics.entity;

import com.soroko.footballleaguestatistics.dto.TeamDto;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
@Table(name = "team_statistics")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamStatistics {

    @Id
    UUID id;

    @NotNull(message = "Position is required")
    @NotBlank(message = "Position is required")
    @Column(name = "position", nullable = false)
    String position;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "matches_played")
    int matchesPlayed;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "wins")
    int wins;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "defeats")
    int defeats;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "draws")
    int draws;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "goals_for")
    int goalsFor;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "goals_against")
    int goalsAgainst;


    @Column(name = "goals_difference")
    int goalsDifference;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "points")
    int points;

  /*  @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "team_id")
    int team;*/

    @OneToMany
    @Indexed(unique = true)
    TeamDto team;
}
