package com.cestiamo.cestiamo.business.impl.repositories;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.domain.Campo;
import com.cestiamo.cestiamo.domain.TipoPartita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPartitaRepository extends JpaRepository<TipoPartita, Long> {

    TipoPartita findTipoPartitaById(Long id) throws BusinessException;


}
