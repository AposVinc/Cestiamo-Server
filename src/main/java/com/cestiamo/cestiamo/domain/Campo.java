package com.cestiamo.cestiamo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Campo")
public class Campo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAMPO", nullable = false)
    private Long id;

    @Column(name = "CITTA", length = 255)
    private String citta;

    @Column(name = "VIA", length = 255)
    private String via;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @JsonIgnore
    @OneToMany(mappedBy = "campo")
    @OrderBy("data asc ")
    private Set<Partita> partite = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Partita> getPartite() {
        return partite;
    }

    public void setPartite(Set<Partita> partite) {
        this.partite = partite;
    }

}
