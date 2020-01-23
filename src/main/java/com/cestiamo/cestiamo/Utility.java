package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.domain.Utente;
import com.cestiamo.cestiamo.spring.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utility {

    public static Utente getUtente() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication: "+authentication);
        if (authentication != null) {
            UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
            return userDetailsImpl.getUtente();
        } else {
            return null;
        }

    }
}
