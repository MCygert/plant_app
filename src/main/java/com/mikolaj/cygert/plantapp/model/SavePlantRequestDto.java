package com.mikolaj.cygert.plantapp.model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
public record SavePlantRequestDto(@NotBlank String plantName,
                                  @NotNull @Positive BigDecimal amount,
                                  String description,
                                  @NotBlank String userName) {

}
