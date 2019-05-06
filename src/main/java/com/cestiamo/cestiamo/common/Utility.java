package com.cestiamo.cestiamo.common;

import com.cestiamo.cestiamo.common.spring.security.UserDetailsImpl;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utility {

	public static Utente getUtente() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
			return userDetailsImpl.getUtente();

		} else {
			return null;
		}
		
	}
}
