package io.developerinator.app.dto;


import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Data
public class TimeRangeDto implements Serializable{

    private static final long serialVersionUID = -9143846734162637741L;

    private LocalTime startTime;

    private LocalTime endTime;
}
