package com.cestiamo.cestiamo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Messaggio")
public class Messaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MESSAGGIO", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_UTENTE", nullable = false)
    private Utente mittente;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "TESTO")
    private String testo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_PARTITA", nullable = false)
    private Partita partita;

    public Messaggio() {
    }

    public Messaggio(Utente u, LocalDateTime d, String t, Partita p) {
        this.mittente = u;
        this.data = d;
        this.testo = t;
        this.partita = p;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getMittente() {
        return mittente;
    }

    public void setMittente(Utente mittente) {
        this.mittente = mittente;
    }

    public LocalDateTime getData(){
        return data;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }

    public String getTesto(){
        return testo;
    }

    public void setTesto( String testo ){
        this.testo = testo;
    }

    public Partita getPartita() {
        return partita;
    }

    public void setPartita(Partita partita) {
        this.partita = partita;
    }

}