package com.jacekg.teamfinder.venue.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.*;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(columnDefinition = "geometry")
    private Point location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "venue_id")
    private List<EventDate> eventDates = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "venue_activity_type",
            joinColumns = {@JoinColumn(name = "venue_id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_type_id")})
    private Set<ActivityType> activities = new HashSet<>();

    public Venue(String name, float price, Set<ActivityType> activities, String address) {
        this.name = name;
        this.price = price;
        this.activities = activities;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Venue [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    public List<Date> getDates() {
        return this.eventDates.stream().map(EventDate::getDate).collect(Collectors.toList());
    }

    public List<String> getActivitiesNames() {
        return this.activities.stream().map(ActivityType::getName).collect(Collectors.toList());
    }

}
