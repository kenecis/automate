package io.developerinator.app.dto;


import lombok.Data;
import org.joda.time.LocalDate;

import java.io.Serializable;

@Data
public class DateRangeDto implements Serializable{

    private static final long serialVersionUID = -7033573532658207021L;

    private LocalDate startDate;

    private LocalDate endDate;
}
