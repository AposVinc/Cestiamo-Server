package com.cestiamo.cestiamo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "tipologia")
    @OrderBy("data asc ")
    private Set<Partita> partite = new HashSet<>();

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

    public Set<Partita> getPartite() {
        return partite;
    }

    public void setPartite(Set<Partita> partite) {
        this.partite = partite;
    }

    @Override
    public String toString() {
        return "TipoPartita{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", n_giocatori=" + n_giocatori +
                '}';
    }
}
