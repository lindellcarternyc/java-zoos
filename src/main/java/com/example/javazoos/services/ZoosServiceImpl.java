package com.example.javazoos.services;

import com.example.javazoos.models.Telephone;
import com.example.javazoos.models.Zoo;
import com.example.javazoos.models.ZooAnimals;
import com.example.javazoos.repositories.ZoosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
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

    @Override
    public Zoo findZooById(long id) {
        return zoosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo with id '" + id + "' NOT FOUND"));
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();

        if (zoo.getZooid() != 0) {
            zoosRepository.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Zoo with id '" + zoo.getZooid() + "' NOT FOUND"));
            newZoo.setZooid(zoo.getZooid());
        }

        newZoo.setZooname(zoo.getZooname());

        newZoo.getTelephones().clear();
        for (Telephone t : zoo.getTelephones()) {
            Telephone newTelephone = new Telephone();
            newTelephone.setPhonenumber(t.getPhonenumber());
            newTelephone.setPhonetype(t.getPhonetype());
            newTelephone.setZooid(t.getZooid());
            newZoo.getTelephones().add(newTelephone);
        }

        newZoo.getAnimals().clear();
        for (ZooAnimals za : zoo.getAnimals()) {
            newZoo
                    .getAnimals()
                    .add(new ZooAnimals(newZoo, za.getAnimal(), za.getIncomingzoo()));
        }
        return zoosRepository.save(newZoo);
    }
}
