package com.example.javazoos.repositories;

import com.example.javazoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZoosRepository extends CrudRepository<Zoo, Long> {
}
