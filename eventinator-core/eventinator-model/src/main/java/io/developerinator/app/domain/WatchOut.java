package io.developerinator.app.domain;

import io.developerinator.app.base.Persistable;
import io.developerinator.app.ref.FilterStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class WatchOut extends Persistable {

    @Column
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private FilterStatus filterStatus;

    @Embedded
    private Location location;

    @Embedded
    private DateRange dateRange;

    @Embedded
    private TimeRange timeRange;

    @Column
    private BigDecimal feeUpperLimit;

    @Column
    private BigDecimal lowerLimit;

    @ElementCollection
    private Set<Interest> interests;
}