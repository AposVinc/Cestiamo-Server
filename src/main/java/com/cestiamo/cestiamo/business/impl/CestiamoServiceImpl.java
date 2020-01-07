package com.cestiamo.cestiamo.business.impl;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.*;
import com.cestiamo.cestiamo.domain.Campo;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.TipoPartita;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CestiamoServiceImpl implements CestiamoService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PartitaRepository partitaRepository;

    @Autowired
    private CampoRepository campoRepository;

    @Autowired
    private TipoPartitaRepository tipoPartitaRepository;

    @Autowired
    private VotazioneRepository votazioneRepository;


    @Override
    public Utente findUtenteByEmail(String email)throws BusinessException{
        return utenteRepository.findUtenteByEmail(email);
    }

    @Override
    public List<Partita> findAllPartite () throws BusinessException {
        return partitaRepository.findAll();
    }

    @Override
    public List<Campo> findAllCampi () throws BusinessException {
        return campoRepository.findAll();
    }

    @Override
    public List<TipoPartita> findAllTypeMatch () throws BusinessException {
        return tipoPartitaRepository.findAll();
    }

    @Override
    public Partita findPartitaById(Long id) throws BusinessException {
        return partitaRepository.findById(id).get();
    }

    @Override
    public void createPartita(Partita partita) throws BusinessException {
        partitaRepository.save(partita);
    }


}
