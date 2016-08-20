package io.developerinator.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocationAndTimeDto implements Serializable{

    private static final long serialVersionUID = -2448648641514949667L;

    private LocationDto location;

    private TimeRangeDto timeRange;

    public boolean locationNotEmpty(){
        return location != null && location.getLattitude() != 0.0d && location.getLongtitude() != 0.0d;
    }

    public boolean timeNotEmpty(){
        return timeRange != null && timeRange.getStartTime() != null && timeRange.getEndTime() != null;
    }
}
