package com.cestiamo.cestiamo.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Bacheca")
public class Bacheca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BACHECA", nullable = false)
    private Long id;
/*
    @ManyToMany
    @JoinColumn(name = "ID_UTENTE", nullable = false)
    private Utente mittente;
*/
/*
    @ManyToOne
    @JoinColumn(name = "ID_PARTITA", nullable = false)
    private Partita partita;
*/
    @Column(name = "DATA")
    private LocalDate data;

    @Column(name = "ORA")
    private LocalTime ora;

    @Column(name = "TESTO")
    private String testo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}