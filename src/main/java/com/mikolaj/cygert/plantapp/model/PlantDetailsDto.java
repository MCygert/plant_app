package com.mikolaj.cygert.plantapp.model;

import com.mikolaj.cygert.plantapp.entity.Plant;
import com.mikolaj.cygert.plantapp.entity.StatusOfBuying;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class PlantDetailsDto {

    String publicId;

    String plantName;

    BigDecimal amount;

    StatusOfBuying statusOfBuying;

    String sellerName;

    String description;

    public PlantDetailsDto(Plant plant) {
        publicId = plant.getPublicId();
        plantName = plant.getPlantName();
        amount = plant.getAmount();
        statusOfBuying = plant.getStatusOfBuying();
        sellerName = plant.getUser().getUserName();
        description = plant.getDescription();
    }

}
