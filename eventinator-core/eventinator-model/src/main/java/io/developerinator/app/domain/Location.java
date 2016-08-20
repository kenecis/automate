package io.developerinator.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@ToString
public class Location {

    @Column
    private double longtitude;

    @Column
    private double lattitude;

    @Column
    private double radius;
}
