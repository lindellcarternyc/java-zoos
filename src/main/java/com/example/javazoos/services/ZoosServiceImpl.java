package com.example.javazoos.services;

import com.example.javazoos.models.Zoo;
import com.example.javazoos.repositories.ZoosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "zoosService")
public class ZoosServiceImpl implements ZoosService {
    @Autowired
    private ZoosRepository zoosRepository;

    @Override
    public List<Zoo> findAllZoos() {
        List<Zoo> zoos = new ArrayList<>();
        zoosRepository.findAll().iterator().forEachRemaining(zoos::add);
        return zoos;
    }
}
