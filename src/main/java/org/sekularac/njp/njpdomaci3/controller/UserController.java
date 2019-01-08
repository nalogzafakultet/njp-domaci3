package org.sekularac.njp.njpdomaci3.controller;

import org.sekularac.njp.njpdomaci3.entities.AppUser;
import org.sekularac.njp.njpdomaci3.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody AppUser user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/find")
    public AppUser findByUsername(@RequestParam("username") String username) {
        return userRepository.findByUsername(username);
    }
}
