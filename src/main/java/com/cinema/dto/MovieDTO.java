package com.cinema.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovieDTO extends BaseDTO {

    private String filmName;

    private LocalTime startTime;

    private LocalTime endTime;

    private int minAge;

    private int maxAge;

    private double price;
}
