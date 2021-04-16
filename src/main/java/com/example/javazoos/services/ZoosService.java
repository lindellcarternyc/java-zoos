package com.example.javazoos.services;

import com.example.javazoos.models.Zoo;

import java.util.List;

public interface ZoosService {
    List<Zoo> findAllZoos();
    Zoo findZooById(long id);
}
