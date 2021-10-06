package com.mikolaj.cygert.plantapp.model;

import com.mikolaj.cygert.plantapp.entity.Plant;
import com.mikolaj.cygert.plantapp.entity.StatusOfBuying;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class PlantDto {

    String publicId;

    String plantName;

    BigDecimal amount;

    StatusOfBuying statusOfBuying;

    public PlantDto(Plant plant) {
        publicId = plant.getPublicId();
        plantName = plant.getPlantName();
        amount = plant.getAmount();
        statusOfBuying = plant.getStatusOfBuying();
    }

}
