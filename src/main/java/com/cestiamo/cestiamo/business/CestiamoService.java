package com.cestiamo.cestiamo.business;

import com.cestiamo.cestiamo.domain.Campo;
import com.cestiamo.cestiamo.domain.Partita;

import java.util.*;

public interface CestiamoService {

    List<Partita> findAllPartite() throws BusinessException;

    List<Campo> findAllCampi() throws BusinessException;
}
