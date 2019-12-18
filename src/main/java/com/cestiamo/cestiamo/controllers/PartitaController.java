package com.cestiamo.cestiamo.controllers;

import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.PartitaRepository;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PartitaController {
    @Autowired
    PartitaRepository partitaRepository;

    @Autowired
    CestiamoService cestiamoService;

    @CrossOrigin()
    @GetMapping("/getListaPartite")
    public List<Partita> getPartite() {
        return cestiamoService.findAllPartite();
    }

    @CrossOrigin()
    @GetMapping("nuovaPartita")
    public void createPartita(@RequestBody Partita p) {
        p.setCampo(p.getCampo());
        p.setData(p.getData());
        p.setTipologia(p.getTipologia());
        cestiamoService.createPartita(p);
        System.out.println("partita creata");
    }

    @GetMapping("/partita/{id}")
    public Partita findById(@PathVariable Long id){
        return partitaRepository.findPartitaById(id);
    }


}
