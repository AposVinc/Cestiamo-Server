package com.cestiamo.cestiamo.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PartitaResponse {

    private Long id;
    private TipoPartita tipologia;
    private Campo campo;
    private LocalDateTime data;
    //private Set<Bacheca> bacheca = new HashSet<>();
    private Set<Utente> partecipanti = new HashSet<>();
    private int personeMancanti;


    public PartitaResponse(){}

    public PartitaResponse(Partita p){
        this.id = p.getId();
        this.campo = p.getCampo();
        this.data = p.getData();
        this.tipologia = p.getTipologia();
        this.partecipanti = p.getPartecipanti();
        this.personeMancanti = tipologia.getN_giocatori() - partecipanti.size();
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public LocalDateTime getData(){
        return data;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }

    public TipoPartita getTipologia(){
        return tipologia;
    }

    public void setTipologia(TipoPartita tipologia) {
        this.tipologia = tipologia;
    }

    public Set<Utente> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(Set<Utente> utentiPartecipanti) {
        this.partecipanti = utentiPartecipanti;
    }

    public void addPartecipante(Utente partecipante) {
        this.partecipanti.add(partecipante);
    }

    public void removePartecipante(Utente partecipante) {
        this.partecipanti.remove(partecipante);
    }

    public int getPersoneMancanti() {
        return personeMancanti;
    }

    public void setPersoneMancanti() {
        this.personeMancanti = this.tipologia.getN_giocatori() - this.partecipanti.size();
    }

}
