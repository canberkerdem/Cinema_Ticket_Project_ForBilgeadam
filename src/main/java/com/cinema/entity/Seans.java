package com.cinema.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "SEANSLAR")
public class Seans extends BaseEntity{

    private String seansName;

    private LocalDate seansDate;

    @ManyToOne
    private Movie movie;
}