package com.cestiamo.cestiamo.controllers;

import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.CampoRepository;
import com.cestiamo.cestiamo.domain.Campo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CampoController {

    @Autowired
    CampoRepository campoRepository;

    @Autowired
    CestiamoService cestiamoService;

    @CrossOrigin
    @GetMapping("/getListaCampi")
    public ArrayList<Campo> getCampi() {
        ArrayList<Campo> list = new ArrayList<Campo>(cestiamoService.findAllCampi());
        return list;
    }

}

