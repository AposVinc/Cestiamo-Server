package com.cestiamo.cestiamo.controllers;

import com.cestiamo.cestiamo.Utility;
import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.CampoRepository;
import com.cestiamo.cestiamo.business.impl.repositories.MessaggioRepository;
import com.cestiamo.cestiamo.business.impl.repositories.PartitaRepository;
import com.cestiamo.cestiamo.business.impl.repositories.UtenteRepository;
import com.cestiamo.cestiamo.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PartitaController {

    @Autowired
    PartitaRepository partitaRepository;

    @Autowired
    UtenteRepository utenteRepository;

    @Autowired
    CampoRepository campoRepository;

    @Autowired
    MessaggioRepository messaggioRepository;

    @Autowired
    CestiamoService cestiamoService;


    @CrossOrigin()
    @GetMapping("/getListaPartite")
    public List<PartitaResponse> getPartite() {
        List<Partita> partite = cestiamoService.findAllPartite();
        List<PartitaResponse> partiteResponse = new ArrayList<>();
        for (Partita p: partite) {
            if (p.getData().isAfter(LocalDateTime.now())){
            partiteResponse.add(new PartitaResponse(p));
            }
        }
        return partiteResponse;
    }


    @CrossOrigin()
    @GetMapping("/getListaMiePartite")
    public List<PartitaResponse> getListaMiePartite(){
        Utente u = utenteRepository.findUtenteByEmail(Utility.getUtente().getEmail());
        Set<Partita> partite = u.getPartiteFuture();
        List<PartitaResponse> partiteResponse = new ArrayList<>();
        for (Partita p :partite){
            if (p.getData().isAfter(LocalDateTime.now())){
                partiteResponse.add(new PartitaResponse(p));
            }
        }
        return partiteResponse;
    }

    @CrossOrigin()
    @GetMapping("/getListaPartiteGiocate")
    public List<PartitaResponse> getListaPartiteGiocate(){
        Utente u = utenteRepository.findUtenteByEmail(Utility.getUtente().getEmail());
        Set<Partita> partite = u.getPartiteGiocate();
        List<PartitaResponse> partiteResponse = new ArrayList<>();
        for (Partita p : partite){
            if (p.getData().isBefore(LocalDateTime.now())){
                partiteResponse.add(new PartitaResponse(p));
            }
        }
        return  partiteResponse;
    }

    @CrossOrigin()
    @GetMapping("/getListaPartite/campo={id}")
    public List<PartitaResponse> getPartiteByCampo(@PathVariable Long id) {
        Campo campo = campoRepository.findCampoById(id);
        Set<Partita> partite = campo.getPartite();
        List<PartitaResponse> partiteResponse = new ArrayList<>();
        for (Partita p: partite) {
            if (p.getData().isAfter(LocalDateTime.now())) {
                partiteResponse.add(new PartitaResponse(p));
            }
        }
        return partiteResponse;
    }

    @CrossOrigin()
    @PostMapping("/nuovaPartita")
    public PartitaResponse createPartita(@RequestBody Partita partita){
        Utente utente = utenteRepository.findUtenteByEmail(Utility.getUtente().getEmail());
        partita.addPartecipante(utente);
        System.out.println(partita.getData());
        return new PartitaResponse(partitaRepository.save(partita));
    }

    @CrossOrigin()
    @GetMapping("/partita/{id}")
    public PartitaResponse findById(@PathVariable Long id){
        Partita p = partitaRepository.findPartitaById(id);
        return new PartitaResponse(p);
    }

    @CrossOrigin()
    @GetMapping("/isPartecipante/partita/{id}")
    public boolean checkIfUtenteLoggatoPartecipate(@PathVariable Long id){
        Utente u = utenteRepository.findUtenteByEmail(Utility.getUtente().getEmail());
        Partita p = partitaRepository.findPartitaById(id);

        return u.isPartecipante(p);
    }


    @CrossOrigin()
    @PutMapping("/addPartecipante/partita={id_p}")
    public PartitaResponse addPartecipante(@PathVariable Long id_p){
        Partita p = partitaRepository.findPartitaById(id_p);
        p.addPartecipante(utenteRepository.findUtenteByEmail(Utility.getUtente().getEmail()));
        partitaRepository.save(p);
        return new PartitaResponse(p);
    }

    @CrossOrigin()
    @DeleteMapping("/removePartecipante/partita={id_p}")
    public void deletePartecipante(@PathVariable Long id_p){
        Partita p = partitaRepository.findPartitaById(id_p);
        p.removePartecipante(utenteRepository.findUtenteByEmail(Utility.getUtente().getEmail()));
        partitaRepository.save(p);
    }

    @CrossOrigin()
    @GetMapping("/partita_bacheca/{id}")
    public Set<Messaggio> findMessaggiByIdPartita(@PathVariable Long id){
        Partita p = partitaRepository.findPartitaById(id);
        return p.getMessaggi();
    }

    @CrossOrigin()
    @PostMapping("/partita_bacheca/{id}/addMessaggio")
    public Messaggio addMessaggio(@PathVariable Long id, @RequestBody Messaggio msg) {
        Partita p = partitaRepository.findPartitaById(id);
        Messaggio m = new Messaggio(utenteRepository.findUtenteByEmail(msg.getMittente().getEmail()), msg.getData(), msg.getTesto(), p);

        return messaggioRepository.save(m);
    }


}
