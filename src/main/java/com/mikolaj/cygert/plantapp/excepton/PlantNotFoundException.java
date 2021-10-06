package com.mikolaj.cygert.plantapp.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User doesn't exists")
public class PlantNotFoundException extends RuntimeException{
}
