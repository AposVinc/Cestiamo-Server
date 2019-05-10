package com.cestiamo.cestiamo.business.impl;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.UtenteRepository;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CestiamoServiceImpl implements CestiamoService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	public Utente findUtenteByEmail(String email) throws BusinessException {
		return utenteRepository.findUtenteByEmail(email);
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findUtenteByEmail(profilo.getEmail());
		utente.setEmail(profilo.getEmail());
		return utente;
	}

}
