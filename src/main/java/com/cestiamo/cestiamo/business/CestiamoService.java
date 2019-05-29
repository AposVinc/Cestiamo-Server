package com.cestiamo.cestiamo.business;

import com.cestiamo.cestiamo.domain.Partita;

import java.util.List;

public interface CestiamoService {

    List<Partita> findAllPartite() throws BusinessException;

}
