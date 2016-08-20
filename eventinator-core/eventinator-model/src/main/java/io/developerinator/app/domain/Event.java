package io.developerinator.app.domain;

import io.developerinator.app.base.Auditable;
import io.developerinator.app.ref.EventSource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Event extends Auditable<Event> {

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Account owner;

    @Embedded
    private TimeRange timeRange;

    @Column
    private BigDecimal fee;

    @ElementCollection
    private Set<Interest> interests;

    @Column
    private boolean visibility;

    @Enumerated(EnumType.STRING)
    private EventSource eventSource;

    @Embedded
    private DateRange dateRange;

    @Embedded
    private Location location;
}
