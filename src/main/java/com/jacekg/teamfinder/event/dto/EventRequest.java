package com.jacekg.teamfinder.event.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventRequest {

    @NotNull(message = "required")
    @Size(min = 1, max = 50, message = "too short/long name")
    private String name;

    @NotNull(message = "required")
    @Size(min = 1, max = 200, message = "too short/long activityType")
    private String activityType;

    @NotNull(message = "required")
    @Min(value = 1, message = "min value 1")
    private long venueId;

    @NotNull(message = "required")
    @Min(value = 1, message = "min value 1")
    private long creatorUserId;

    @NotNull(message = "required")
    @Min(value = 0, message = "min value 0")
    @Max(value = 1000, message = "max value 1000")
    private float price;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-SS")
    @NotNull(message = "required")
    private LocalDateTime date;

    public void setName(String name) {
        if (name != null) {
            this.name = name.trim();
        }
    }

    public void setActivityType(String activityType) {
        if (activityType != null) {
            this.activityType = activityType.trim();
        }
    }
}
