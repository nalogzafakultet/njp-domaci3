package org.sekularac.njp.njpdomaci3.controller;

import org.sekularac.njp.njpdomaci3.entities.Proizvod;
import org.sekularac.njp.njpdomaci3.entities.Recept;
import org.sekularac.njp.njpdomaci3.repos.ProizvodRepository;
import org.sekularac.njp.njpdomaci3.repos.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recepti")
public class ReceptController {

    @Autowired
    private ReceptRepository receptRepository;

    @GetMapping
    public Iterable<Recept> getAll() {
        return receptRepository.findAll();
    }

    @PostMapping
    public Recept addNew(@RequestBody Recept recept) {
        return receptRepository.save(recept);
    }

    @GetMapping("/{id}")
    public Recept getReceptById(@PathVariable Long id) {
        return receptRepository.findById(id).get();
    }

    @GetMapping("/search")
    public List<Recept> searchReceptsByName(@RequestParam("name") String name) {
        return receptRepository.findAllByNazivContains(name);
    }

    @PostMapping("/search")
    public List<Recept> searchReceptsByProizvodi(@RequestBody List<Proizvod> proizvodi) {
        List<Recept> matchovaniRecepti = new ArrayList<>();

        Iterable<Recept> sviRecepti = receptRepository.findAll();

        boolean nisamMatchovanJbg = false;

        for (Recept recept: sviRecepti) {
            nisamMatchovanJbg = false;
            for (Proizvod proizvod: proizvodi) {
                if (!recept.getProizvodi().contains(proizvod)) {
                    nisamMatchovanJbg = true;
                    break;
                }
            }

            if (!nisamMatchovanJbg) {
                matchovaniRecepti.add(recept);
            }
        }
        return matchovaniRecepti;
    }

    @PostMapping("/update")
    public Recept updateRecept(@RequestBody Recept recept) {
        return receptRepository.save(recept);
    }


}
