package com.cinema.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "AUDIENCES")
public class Audience extends BaseEntity {

    private String audienceName;

    private String audienceSurname;

    private int age;

}