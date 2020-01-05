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
public class PartitaController {

    @Autowired
    PartitaRepository partitaRepository;

    @Autowired
    CestiamoService cestiamoService;

    @CrossOrigin()
    @GetMapping("/getListaPartite")
    public List<PartitaResponse> getPartite() {
        List<Partita> partite = cestiamoService.findAllPartite();
        List<PartitaResponse> partiteResponse = new ArrayList<>();
        for (Partita p: partite) {
            partiteResponse.add(new PartitaResponse(p));
        }
        return partiteResponse;
    }

    @CrossOrigin()
    @PostMapping("/nuovaPartita")
    controllare
    public Partita createPartita(Partita partita) {
        System.out.println("METODO CREA PARTITA");
        Partita p= new Partita();
        p.setCampo(partita.getCampo());
        p.setData(partita.getData());
        p.setTipologia(partita.getTipologia());
        cestiamoService.createPartita(partita);
        System.out.println("partita creata");
        return p;
    }

    @CrossOrigin()
    @GetMapping("/partita/{id}")
    public PartitaResponse findById(@PathVariable Long id){
        Partita p = partitaRepository.findPartitaById(id);
        return new PartitaResponse(p);
    }

    @CrossOrigin()
    @PutMapping("/addPartecipante/partita={id_p}/utente={mail_u}")
    public void addPartecipante(@PathVariable Long id_p, @PathVariable String mail_u){
        System.out.println(id_p + "  " + mail_u +"\n");

        Partita p = partitaRepository.findPartitaById(id_p);
        p.addPartecipante(cestiamoService.findUtenteByEmail(mail_u));

        partitaRepository.save(p);
    }

    @CrossOrigin()
    @DeleteMapping("/removePartecipante/partita={id_p}/utente={mail_u}")
    public void deletePartecipante(@PathVariable Long id_p, @PathVariable String mail_u){
        Partita p = partitaRepository.findPartitaById(id_p);
        p.removePartecipante(cestiamoService.findUtenteByEmail(mail_u));
        partitaRepository.save(p);
    }

}
