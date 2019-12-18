package com.cestiamo.cestiamo.business.impl.repositories;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Utente findUtenteByEmail(String email);

    Utente findUtenteById(Long id);



}
