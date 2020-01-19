package com.cestiamo.cestiamo.business.impl.repositories;

import com.cestiamo.cestiamo.domain.Utente;
import com.cestiamo.cestiamo.domain.Votazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotazioneRepository extends JpaRepository<Votazione, Long> {

    Votazione findByVotanteAndVotato(Utente votante, Utente votato );


}
