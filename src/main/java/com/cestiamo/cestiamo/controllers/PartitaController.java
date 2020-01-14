package com.cestiamo.cestiamo.controllers;

import com.cestiamo.cestiamo.business.CestiamoService;
import com.cestiamo.cestiamo.business.impl.repositories.MessaggioRepository;
import com.cestiamo.cestiamo.business.impl.repositories.PartitaRepository;
import com.cestiamo.cestiamo.domain.Messaggio;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.PartitaResponse;

import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PartitaController {

    @Autowired
    PartitaRepository partitaRepository;

    @Autowired
    UserController utenteRepository;

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
            partiteResponse.add(new PartitaResponse(p));}
        }
        return partiteResponse;
    }


    @CrossOrigin()
    @GetMapping("/getListaMiePartite/utente={mail}")
    public List<PartitaResponse> getListaMiePartite(@PathVariable String mail){
        Utente u = cestiamoService.findUtenteByEmail(mail);
        Set<Partita> partite = u.getPartiteGiocate();
        List<PartitaResponse> partiteResponse = new ArrayList<>();
        for (Partita p :partite){
            if (p.getData().isAfter(LocalDateTime.now())){
                partiteResponse.add(new PartitaResponse(p));
            }
        }
        return partiteResponse;
    }

    @CrossOrigin()
    @GetMapping("/getListaPartiteGiocate/utente={mail}")
    public List<PartitaResponse> getListaPartiteGiocate(@PathVariable String mail){
        Utente u = cestiamoService.findUtenteByEmail(mail);
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
    @PostMapping("/nuovaPartita")
    public PartitaResponse createPartita(@RequestBody Partita p, @RequestBody Utente u){
        p.addPartecipante(u);
        System.out.println(p);
        return new PartitaResponse(partitaRepository.save(p));
    }

    @CrossOrigin()
    @GetMapping("/partita/{id}")
    public PartitaResponse findById(@PathVariable Long id){
        Partita p = partitaRepository.findPartitaById(id);
        return new PartitaResponse(p);
    }

    @CrossOrigin()
    @PutMapping("/addPartecipante/partita={id_p}/utente={mail_u}")
    public PartitaResponse addPartecipante(@PathVariable Long id_p, @PathVariable String mail_u){
        Partita p = partitaRepository.findPartitaById(id_p);
        p.addPartecipante(cestiamoService.findUtenteByEmail(mail_u));

        partitaRepository.save(p);
        return new PartitaResponse(p);
    }

    @CrossOrigin()
    @DeleteMapping("/removePartecipante/partita={id_p}/utente={mail_u}")
    public void deletePartecipante(@PathVariable Long id_p, @PathVariable String mail_u){
        Partita p = partitaRepository.findPartitaById(id_p);
        p.removePartecipante(cestiamoService.findUtenteByEmail(mail_u));
        partitaRepository.save(p);
    }

    @CrossOrigin()
    @GetMapping("/partita/{id}/bacheca")
    public Set<Messaggio> findMessaggiByIdPartita(@PathVariable Long id){
        Partita p = partitaRepository.findPartitaById(id);
        return p.getMessaggi();
    }

    @CrossOrigin()
    @PostMapping("/partita/{id}/bacheca/addMessaggio")
    public Messaggio addMessaggio(@PathVariable Long id, @RequestBody Messaggio msg) {
        Partita p = partitaRepository.findPartitaById(id);
        Messaggio m = new Messaggio(utenteRepository.findByEmail(msg.getMittente().getEmail()), msg.getData(), msg.getTesto(), p);

        return messaggioRepository.save(m);
    }


}
