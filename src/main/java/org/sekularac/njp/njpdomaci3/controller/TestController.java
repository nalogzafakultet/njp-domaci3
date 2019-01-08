package org.sekularac.njp.njpdomaci3.controller;

import org.sekularac.njp.njpdomaci3.entities.AppUser;
import org.sekularac.njp.njpdomaci3.entities.Proizvod;
import org.sekularac.njp.njpdomaci3.entities.Recept;
import org.sekularac.njp.njpdomaci3.repos.ProizvodRepository;
import org.sekularac.njp.njpdomaci3.repos.ReceptRepository;
import org.sekularac.njp.njpdomaci3.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProizvodRepository proizvodRepository;

    @Autowired
    ReceptRepository receptRepository;

    @GetMapping
    public String index() {
        return "Hi";
    }

    @PostMapping
    public AppUser newUser(@RequestBody AppUser user) {
        return userRepository.save(user);
    }

    @PostMapping("/abc")
    public String postic() {
        return "ASDASD";
    }


    @GetMapping("/test")
    public String addTestData() {
        Proizvod mleko = new Proizvod("Mleko");
        proizvodRepository.save(mleko);
        Proizvod pahuljice = new Proizvod("Pahuljice");
        proizvodRepository.save(pahuljice);
        Recept recept = new Recept("Pahuljice sa mlekom", "He he");
        recept.addProizvod(mleko);
        recept.addProizvod(pahuljice);
        receptRepository.save(recept);
        return "ADDED";
    }
}
