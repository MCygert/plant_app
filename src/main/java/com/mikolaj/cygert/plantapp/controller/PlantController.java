package com.mikolaj.cygert.plantapp.controller;

import com.mikolaj.cygert.plantapp.model.PlantDetailsDto;
import com.mikolaj.cygert.plantapp.model.PlantDto;
import com.mikolaj.cygert.plantapp.model.SavePlantRequestDto;
import com.mikolaj.cygert.plantapp.service.PlantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlantController {
    private PlantService plantService;

    @GetMapping("/plants")
    public List<PlantDto> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/plants/{id}")
    public PlantDetailsDto getPlantDetails(@PathVariable String id) {
        return plantService.getPlantDetails(id);
    }

    @PostMapping("/plants")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String savePlant(@RequestBody @Valid SavePlantRequestDto savePlantRequestDto) {
        return plantService.savePlant(savePlantRequestDto);
    }

    @DeleteMapping("/plants/{id}")
    public void deletePlant(@PathVariable String id) {
        plantService.deletePlant(id);
    }
}
