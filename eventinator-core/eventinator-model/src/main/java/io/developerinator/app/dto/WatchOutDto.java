package io.developerinator.app.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import io.developerinator.app.domain.FilterStatus;
import lombok.Data;

@Data
public class WatchOutDto implements Serializable{

    private static final long serialVersionUID = -1640675657201815894L;

    private String title;

    private String description;

    private FilterStatus filterStatus;

    private LocationDto location;

    private DateRangeDto dateRange;

    private TimeRangeDto timeRange;

    private BigDecimal feeUpperLimit;

    private BigDecimal lowerLimit;

    private Set<InterestDto> interests;
}
