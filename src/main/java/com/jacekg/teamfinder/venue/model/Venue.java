package com.jacekg.teamfinder.venue.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.*;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venue")
@DiscriminatorColumn(name = "venue_type")
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
