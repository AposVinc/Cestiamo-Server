package com.cestiamo.cestiamo.spring.security;

import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CestiamoService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Utente utente=service.findUtenteByEmail(email);
        if (utente == null){
            throw new UsernameNotFoundException("Utente Inesistente");
        }
        return new UserDetailsImpl(utente);
    }
}
