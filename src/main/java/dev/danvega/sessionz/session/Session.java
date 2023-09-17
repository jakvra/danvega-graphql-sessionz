package dev.danvega.sessionz.session;

import dev.danvega.sessionz.event.Event;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public final class Session {

        @Id
        private Integer id;
        private String title;
        @Column(columnDefinition = "TEXT")
        private String description;
        @Enumerated(EnumType.STRING)
        private Level level;
        @ManyToMany
        @JoinTable(
                name = "session_tags",
                joinColumns = @JoinColumn(name = "tag_id"),
                inverseJoinColumns = @JoinColumn(name = "session_id"))
        private Set<Tag> tags;
        @ManyToOne
        private Event event;

    public Session(Integer id, String title, String description, Level level, Set<Tag> tags, Event event) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.tags = tags;
        this.event = event;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", tags=" + tags +
                ", event=" + event +
                '}';
    }
}