package com.soroko.footballleaguestatistics.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author yuriy.soroko
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamDTO {
    String name;
    String city;
    String stadium;
}
