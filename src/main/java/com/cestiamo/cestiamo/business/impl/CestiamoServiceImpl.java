package com.cestiamo.cestiamo.business.impl;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.*;
import com.cestiamo.cestiamo.domain.Campo;
import com.cestiamo.cestiamo.domain.Partita;
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

    @Override
    public List<Partita> findAllPartite () throws BusinessException {
        return partitaRepository.findAll();
    }

    @Override
    public List<Campo> findAllCampi () throws BusinessException {
        return campoRepository.findAll();
    }

    @Override
    public Partita findPartitaById(long id) throws BusinessException {
        return partitaRepository.findById(id).get();
    }


}
