package io.developerinator.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocationDto implements Serializable{

    private static final long serialVersionUID = -5156097121600940230L;

    private double longtitude;

    private double lattitude;

    private double radius;
}
