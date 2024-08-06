package com.soroko.footballleaguestatistics.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author yuriy.soroko
 */

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamDTO {
    String name;
    String city;
    String stadium;
}
