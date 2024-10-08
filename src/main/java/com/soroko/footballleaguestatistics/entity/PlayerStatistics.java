package com.soroko.footballleaguestatistics.entity;


import com.soroko.footballleaguestatistics.dto.PlayerDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
@Table(name = "player_statistics")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerStatistics {

    @Id
    UUID id;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Column(name = "matches_played")
    int matchesPlayed;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer = 3, fraction = 0, message = "Invalid amount of goals")
    @Column(name = "goals_scored")
    int goalsScored;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer = 2, fraction = 0, message = "Invalid amount of yellow cards")
    @Column(name = "yellow_cards")
    int yellowCards;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer = 2, fraction = 0, message = "Invalid amount of red cards")
    @Column(name = "red_cards")
    int redCards;

    @PositiveOrZero(message = "Positive or zero value is required")
    @Digits(integer = 2, fraction = 0, message = "Invalid amount of submissions")
    @Column(name = "submissions")
    int submissions;

    @OneToMany
    @Indexed(unique = true)
    PlayerDTO player;
}
