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

    private String activityType;

    private LocalDateTime date;

    private float price;

    private Long venueId;

    private Long creatorUserId;

    private List<Long> usersId = new ArrayList<>();
}
