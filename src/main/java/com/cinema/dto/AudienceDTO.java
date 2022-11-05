package com.cinema.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@Data
public class AudienceDTO extends BaseDTO {


    private String audienceName;

    @NotNull(message = "audienceSurname field is mandatory")
    private String audienceSurname;

    @NotNull(message = "age field is mandatory")
    private int age;
}
