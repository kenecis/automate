package io.developerinator.app.dto;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class DateRangeDto implements Serializable{

    private static final long serialVersionUID = -7033573532658207021L;

    private Date startDate;

    private Date endDate;
}
