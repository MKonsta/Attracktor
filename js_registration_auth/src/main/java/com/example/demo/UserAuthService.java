package com.example.demo;

import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private PersonRepo personRepo;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return personRepo.findByLogin(s);
    }
}
