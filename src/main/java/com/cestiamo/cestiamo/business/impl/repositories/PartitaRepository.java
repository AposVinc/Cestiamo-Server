package com.cestiamo.cestiamo.business.impl.repositories;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.domain.Partita;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PartitaRepository extends JpaRepository<Partita, Long> {

    Partita findPartitaById(Long id) throws BusinessException;


}
