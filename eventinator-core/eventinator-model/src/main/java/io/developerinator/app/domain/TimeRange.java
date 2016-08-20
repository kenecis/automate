package io.developerinator.app.domain;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@ToString
public class TimeRange {

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;
}
