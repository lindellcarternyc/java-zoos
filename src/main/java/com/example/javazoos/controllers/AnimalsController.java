package com.example.javazoos.controllers;

import com.example.javazoos.services.AnimalsService;
import com.example.javazoos.views.AnimalZooCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/animals")
public class AnimalsController {
    @Autowired
    private AnimalsService animalsService;

    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> getAnimalZooCounts() {
        List<AnimalZooCounts> animalZooCounts = animalsService.findAnimalZooCounts();

        return new ResponseEntity<>(animalZooCounts, HttpStatus.OK);
    }
}
