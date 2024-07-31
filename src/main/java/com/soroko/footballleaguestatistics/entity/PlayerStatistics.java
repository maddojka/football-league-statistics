package com.soroko.footballleaguestatistics.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "player_statistics")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "matches_played")
    int matchesPlayed;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=3, fraction=0, message="Invalid amount of goals")
    @Column(name = "goals_scored")
    int goalsScored;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=2, fraction=0, message="Invalid amount of yellow cards")
    @Column(name = "yellow_cards")
    int yellowCards;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=2, fraction=0, message="Invalid amount of red cards")
    @Column(name = "red_cards")
    int redCards;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer=2, fraction=0, message="Invalid amount of submissions")
    @Column(name = "submissions")
    int submissions;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "player_id")
    int player;
}
