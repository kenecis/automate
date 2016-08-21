package io.developerinator.app.dto;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TimeRangeDto implements Serializable{

    private static final long serialVersionUID = -9143846734162637741L;

    private Date startTime;

    private Date endTime;
}
