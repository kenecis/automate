package io.developerinator.app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.joda.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@ToString
public class DateRange {

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;
}
