package com.cestiamo.cestiamo.controllers;

import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.PartitaRepository;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.PartitaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PartitaController
{
    @Autowired
    PartitaRepository partitaRepository;

    @Autowired
    CestiamoService cestiamoService;

    @CrossOrigin()
    @GetMapping("/getListaPartite")
    public List<PartitaResponse> getPartite() {
        List<Partita> l = cestiamoService.findAllPartite();
        ArrayList<PartitaResponse> list = new ArrayList<>();

        l.forEach(partita -> {
            PartitaResponse p = new PartitaResponse(partita);
            list.add(p);
        });
        return list;
    }

}
