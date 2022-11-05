package com.cinema.dto;

import com.cinema.entity.Movie;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class SeansDTO extends BaseDTO{

    private String seansName;

    private LocalDate seansDate;

    private Movie film;
}
