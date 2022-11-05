package com.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class TicketDTO extends BaseDTO{
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String ticketNumber;

    private SeansDTO seans;

    private Set<AudienceDTO> audienceSet;
}
