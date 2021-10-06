package com.mikolaj.cygert.plantapp.service;

import com.mikolaj.cygert.plantapp.entity.Plant;
import com.mikolaj.cygert.plantapp.entity.StatusOfBuying;
import com.mikolaj.cygert.plantapp.excepton.PlantNotFoundException;
import com.mikolaj.cygert.plantapp.model.PlantDetailsDto;
import com.mikolaj.cygert.plantapp.model.PlantDto;
import com.mikolaj.cygert.plantapp.model.SavePlantRequestDto;
import com.mikolaj.cygert.plantapp.repository.PlantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class PlantService {
    private PlantRepository plantRepository;
    private UserService userService;

    // Add pagination and sorting
    public List<PlantDto> getAllPlants() {
        log.info("Getting all plants");
        return plantRepository.findAll()
                .stream()
                .map(PlantDto::new)
                .collect(Collectors.toList());
    }

    public PlantDetailsDto getPlantDetails(String publicId) {
        log.info("Fetching details for plant id: {}", publicId);
        return plantRepository.findByPublicId(publicId)
                .map(PlantDetailsDto::new)
                .orElseThrow(PlantNotFoundException::new);
    }

    public String savePlant(SavePlantRequestDto plantDetailsDto) {
        log.info("Saving plant with details: {}", plantDetailsDto);
        return plantRepository.save(fromSavePlantRequest(plantDetailsDto)).getPublicId();
    }

    //Check if plant is user property
    public void deletePlant(String publicId) {
        log.info("Deleting plant with id: {}", publicId);
        plantRepository.deleteByPublicId(publicId);
    }
    //Add updating

    private Plant fromSavePlantRequest(SavePlantRequestDto savePlantRequestDto) {
        Plant plant = new Plant();
        plant.setPublicId(UUID.randomUUID().toString());
        plant.setPlantName(savePlantRequestDto.getPlantName());
        plant.setAmount(savePlantRequestDto.getAmount());
        plant.setDescription(savePlantRequestDto.getDescription());
        plant.setStatusOfBuying(StatusOfBuying.AVAILABLE);
        plant.setUser(userService.findUser(savePlantRequestDto.userName()));
        return plant;
    }
}
