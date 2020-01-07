package com.cestiamo.cestiamo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate data;

    @Column(name = "ORA")
    private LocalTime ora;

    @Column(name = "TESTO")
    private String testo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_PARTITA", nullable = false)
    private Partita partita;



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

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra ( LocalTime ora ) {
        this.ora = ora;
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