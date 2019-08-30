package com.cestiamo.cestiamo.domain;

import javax.persistence.*;

@Entity
@Table(name = "TipoPartita")
public class TipoPartita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_PARTITA", nullable = false)
    private Long id;

    @Column(name = "TIPOLOGIA_PARTITA", length = 255, nullable = false)
    private String nome;

    @Column(name = "NUMERO_GIOCATORI", length = 255, nullable = false)
    private int n_giocatori;
/*
    @OneToMany(mappedBy = "tipopartita")
    private Set<Partita> partite = new HashSet<Partita>();
*/
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
