package com.jacekg.teamfinder.event.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Location {

    private double lat;
    private double lng;
}
