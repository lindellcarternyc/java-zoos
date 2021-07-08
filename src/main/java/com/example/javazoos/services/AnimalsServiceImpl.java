package com.example.javazoos.services;

import com.example.javazoos.repositories.AnimalsRepository;
import com.example.javazoos.views.AnimalZooCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "animalsService")
public class AnimalsServiceImpl implements AnimalsService {
    @Autowired
    private AnimalsRepository animalsRepository;

    @Override
    public List<AnimalZooCounts> findAnimalZooCounts() {
        return animalsRepository.findAnimalZooCounts();
    }
}
