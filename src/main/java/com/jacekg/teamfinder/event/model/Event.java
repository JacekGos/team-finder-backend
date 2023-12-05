package com.jacekg.teamfinder.event.model;

import com.jacekg.teamfinder.user.model.User;
import com.jacekg.teamfinder.activitytype.model.ActivityType;
import com.jacekg.teamfinder.venue.model.Venue;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "event")
@DiscriminatorColumn(name = "event_type")
public abstract class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "activity_type_id")
    protected ActivityType activityType;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "price", nullable = false)
    private float price;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToMany(mappedBy = "participatedGames")
    private Set<User> players = new HashSet<>();

    public Event(String name, ActivityType activityType, Venue venue, User creator, LocalDateTime date, float price) {
        this.name = name;
        this.activityType = activityType;
        this.venue = venue;
        this.creator = creator;
        this.date = date;
        this.price = price;
        this.players.add(creator);
    }

    public List<Long> getPlayersId() {
        return this.players.stream().map(User::getId).collect(Collectors.toList());
    }

    public long getVenueId() {
        return venue != null ? venue.getId() : 0;
    }

    public long getCreatorUserId() {
        return creator != null ? creator.getId() : 0;
    }

    public void addUser(User user) {
        this.players.add(user);
    }
}
