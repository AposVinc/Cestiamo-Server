package com.cestiamo.cestiamo.business;

import com.cestiamo.cestiamo.domain.Utente;

public interface CestiamoService {

	Utente findUtenteByEmail(String email) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

}
