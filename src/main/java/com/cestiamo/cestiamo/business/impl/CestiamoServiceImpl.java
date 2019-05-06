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
	public Utente findUtenteByCognome(String cognome) throws BusinessException {
		return utenteRepository.findByCognome(cognome);
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByCognome(profilo.getCognome());
		utente.setEmail(profilo.getEmail());
		return utente;
	}

}
