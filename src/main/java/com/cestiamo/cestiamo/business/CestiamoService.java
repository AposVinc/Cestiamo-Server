package com.cestiamo.cestiamo.business;

import com.cestiamo.cestiamo.domain.Campo;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.TipoPartita;
import com.cestiamo.cestiamo.domain.Utente;

import java.util.*;

public interface CestiamoService {

    Utente findUtenteByEmail(String email) throws BusinessException;

    List<Partita> findAllPartite() throws BusinessException;

    List<Campo> findAllCampi() throws BusinessException;

    List<TipoPartita> findAllTypeMatch() throws BusinessException;

    Partita findPartitaById(long id) throws BusinessException;
}
