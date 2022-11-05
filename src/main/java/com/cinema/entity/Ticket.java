package com.cinema.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "TICKETS")

public class Ticket extends BaseEntity{

    @Column
    private String ticketNumber;

    @ManyToOne
    private Seans seans;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Audience> audienceSet;


}
