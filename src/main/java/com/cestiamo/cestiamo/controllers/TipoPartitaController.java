package com.cestiamo.cestiamo.controllers;

import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.TipoPartitaRepository;
import com.cestiamo.cestiamo.domain.TipoPartita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoPartitaController {

    @Autowired
    TipoPartitaRepository tipoPartitaRepository;

    @Autowired
    CestiamoService cestiamoService;

    @CrossOrigin
    @GetMapping("/getListaTipoPartita")
    public ArrayList<TipoPartita> getTipoPartita() {
        return new ArrayList<>(cestiamoService.findAllTypeMatch());
    }
}
