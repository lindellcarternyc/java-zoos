package com.example.javazoos.controllers;

import com.example.javazoos.models.Zoo;
import com.example.javazoos.services.ZoosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> getZoo(@PathVariable long zooid) {
        Zoo zoo = zoosService.findZooById(zooid);

        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @PostMapping(value = "/zoo", consumes = "application/json")
    public ResponseEntity<?> addNewZoo(@Valid @RequestBody Zoo newZoo) {
        newZoo.setZooid(0);
        newZoo = zoosService.save(newZoo);
        System.out.println("NEW ZOO: " + newZoo.getZooname() + " " + newZoo.getZooid());
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{zooid}")
                .buildAndExpand(newZoo.getZooid())
                .toUri();
        responseHeaders.setLocation(newZooURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
