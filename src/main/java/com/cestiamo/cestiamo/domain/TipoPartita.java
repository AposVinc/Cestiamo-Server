package com.cestiamo.cestiamo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoPartita")
public class TipoPartita {
    @Id
    @Column(name = "ID_TIPO_PARTITA", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "NUMERO_GIOCATORI", length = 255, nullable = false)
    private int n_giocatori;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getN_giocatori() {
        return n_giocatori;
    }

    public void setN_giocatori(int quantita) {
        this.n_giocatori = quantita;
    }

}
