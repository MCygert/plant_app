package com.mikolaj.cygert.plantapp.repository;

import com.mikolaj.cygert.plantapp.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, String> {

    void deleteByPublicId(String publicId);

    Optional<Plant> findByPublicId(String publicId);
}
