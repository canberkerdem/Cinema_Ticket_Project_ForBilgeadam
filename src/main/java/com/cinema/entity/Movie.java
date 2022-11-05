package com.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "MOVIE")
public class Movie extends BaseEntity{

    private String movieName;

    private LocalTime startTime;

    private LocalTime endTime;

    private int minAge;

    private int maxAge;

    private double price;
}