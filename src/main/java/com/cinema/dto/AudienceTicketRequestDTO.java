package com.cinema.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class AudienceTicketRequestDTO {
    @NotNull
    private Long seansId;

    private Set<AudienceDTO> audienceSet;
}
