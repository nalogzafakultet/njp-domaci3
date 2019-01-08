package org.sekularac.njp.njpdomaci3.service;

import org.sekularac.njp.njpdomaci3.entities.AppUser;
import org.sekularac.njp.njpdomaci3.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(s);
        if (appUser == null) {
            throw new UsernameNotFoundException(s);
        }
        return new User(appUser.getUsername(), appUser.getPassword(), Collections.emptyList());
    }
}
