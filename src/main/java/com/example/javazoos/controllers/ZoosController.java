package com.example.javazoos.controllers;

import com.example.javazoos.models.Zoo;
import com.example.javazoos.services.ZoosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/zoos")
public class ZoosController {
    @Autowired
    private ZoosService zoosService;

    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> getAllZoos() {
        List<Zoo> zoos = zoosService.findAllZoos();

        return new ResponseEntity<>(zoos, HttpStatus.OK);
    }
}
