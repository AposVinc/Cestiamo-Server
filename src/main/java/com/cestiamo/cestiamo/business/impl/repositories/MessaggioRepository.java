package com.cestiamo.cestiamo.business.impl.repositories;

import com.cestiamo.cestiamo.domain.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessaggioRepository  extends JpaRepository<Messaggio, Long> {
}
