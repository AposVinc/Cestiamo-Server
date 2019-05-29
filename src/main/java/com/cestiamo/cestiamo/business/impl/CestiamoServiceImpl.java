package com.cestiamo.cestiamo.business.impl;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.PartitaRepository;
import com.cestiamo.cestiamo.business.impl.repositories.UtenteRepository;
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

    @Override
    public List<Partita> findAllPartite () throws BusinessException {
        return partitaRepository.findAll();
    }


}
