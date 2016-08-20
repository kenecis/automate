package io.developerinator.app.dto;


import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class IteneraryDto implements Serializable{

    private static final long serialVersionUID = 4207752782863115574L;

    private String name;

    private String description;

    private boolean visibility;

    private List<LocationAndTimeDto> locationAndTime;

    private List<InterestDto> interests;

    private double radius;
}
