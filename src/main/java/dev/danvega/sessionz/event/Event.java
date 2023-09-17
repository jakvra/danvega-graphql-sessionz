package dev.danvega.sessionz.event;

import dev.danvega.sessionz.session.Session;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event {

    @Id
    private Integer id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate cfpStartDate;
    private LocalDate cfpEndDate;
    private String location;
    private String website;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    //@JoinColumn(name = "event_id"),
    private Set<Session> sessions = new HashSet<>();

    public Event(Integer id, String name, String description, LocalDate startDate, LocalDate endDate, LocalDate cfpStartDate, LocalDate cfpEndDate, String location, String website) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cfpStartDate = cfpStartDate;
        this.cfpEndDate = cfpEndDate;
        this.location = location;
        this.website = website;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cfpStartDate=" + cfpStartDate +
                ", cfpEndDate=" + cfpEndDate +
                ", location='" + location + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}