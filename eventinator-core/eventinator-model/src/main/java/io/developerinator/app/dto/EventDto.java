package io.developerinator.app.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import io.developerinator.app.domain.EventSource;
import lombok.Data;

@Data
public class EventDto implements Serializable{

    private static final long serialVersionUID = -2049029458729282811L;

    private String title;

    private String description;

    private TimeRangeDto timeRange;

    private DateRangeDto dateRange;

    private BigDecimal fee;

    private Set<InterestDto> interests;

    private boolean visibility;

    private EventSource eventSource;

    private LocationDto location;
}
