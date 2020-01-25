package com.cestiamo.cestiamo.business.impl.repositories;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.domain.Campo;
import com.cestiamo.cestiamo.domain.Partita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampoRepository extends JpaRepository<Campo, Long> {

    Campo findCampoById(Long id) throws BusinessException;


}
