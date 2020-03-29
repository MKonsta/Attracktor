package com.example.exam;

import com.example.exam.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return personService.getByEmail(s);
    }
}
