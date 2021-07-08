package com.example.javazoos.repositories;

import com.example.javazoos.models.Animal;
import com.example.javazoos.views.AnimalZooCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalsRepository extends CrudRepository<Animal, Long> {
    @Query(value = "SELECT a.animaltype AS animaltype, a.animalid AS animalid, count(z.zooid) countzoos " +
            "FROM animals a " +
            "LEFT JOIN zooanimals za ON (a.animalid = za.animalid) " +
            "LEFT JOIN zoos z ON (za.zooid = z.zooid) " +
            "GROUP BY animaltype",
            nativeQuery = true)
    List<AnimalZooCounts> findAnimalZooCounts();
}
