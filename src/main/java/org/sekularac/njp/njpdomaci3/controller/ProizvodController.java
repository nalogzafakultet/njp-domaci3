package org.sekularac.njp.njpdomaci3.controller;

import org.sekularac.njp.njpdomaci3.entities.Proizvod;
import org.sekularac.njp.njpdomaci3.entities.Recept;
import org.sekularac.njp.njpdomaci3.repos.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/proizvodi")
public class ProizvodController {

    @Autowired
    ProizvodRepository proizvodRepository;

    @GetMapping
    public Iterable<Proizvod> getAll() {
        return proizvodRepository.findAll();
    }

    @PostMapping
    public Proizvod addNew(@RequestBody Proizvod proizvod) {
        return proizvodRepository.save(proizvod);
    }

    @GetMapping("/{id}")
    public Proizvod getById(@PathVariable Long id) {
        return proizvodRepository.findById(id).get();
    }

    @PostMapping("/diff")
    public List<Proizvod> findRemaining(@RequestBody Recept recept) {
        System.out.println(recept);
        List<Long> ids = new ArrayList<>();

        for (Proizvod proizvod: recept.getProizvodi()) {
            ids.add(proizvod.getId());
        }

        return proizvodRepository.findAllByIdNotIn(ids);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProizvodById(@PathVariable Long id) {
        try {
            proizvodRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
