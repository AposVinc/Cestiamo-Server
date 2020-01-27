package com.cestiamo.cestiamo.business;

import com.cestiamo.cestiamo.domain.Campo;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.TipoPartita;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

public interface CestiamoService {

    Utente findUtenteByEmail(String email) throws BusinessException;

    List<Partita> findAllPartite() throws BusinessException;

    List<Campo> findAllCampi() throws BusinessException;

    List<TipoPartita> findAllTypeMatch() throws BusinessException;
    
    void createPartita(Partita partita) throws BusinessException;

    Partita findPartitaById(Long id) throws BusinessException;

    Campo findCampoById(Long id) throws BusinessException;

    TipoPartita findTipoPartitaById(Long id) throws BusinessException;

}
