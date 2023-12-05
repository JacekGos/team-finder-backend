package com.jacekg.teamfinder.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventResponse {

    private long id;

    private String name;

    private Long venueId;

    private Location location;

    private String city;

    private String street;

    private Long creatorUserId;

    private String creatorUsername;

    private List<Long> playersId = new ArrayList<>();

    private String activityType;

    private float price;

    private LocalDateTime date;
}
