package com.mikolaj.cygert.plantapp.model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public record AuthorizeRequestDto(@NotBlank String userName,
                                  @NotBlank String password) {


}
