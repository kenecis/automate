package io.developerinator.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@ToString
public class TimeRange {

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date endTime;
}
