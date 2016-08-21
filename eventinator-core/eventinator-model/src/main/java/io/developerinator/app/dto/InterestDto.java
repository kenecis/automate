package io.developerinator.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InterestDto implements Serializable{

    private static final long serialVersionUID = 6911376314923407481L;

    private Long id;

    private String name;
}
