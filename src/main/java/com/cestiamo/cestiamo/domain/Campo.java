package com.cestiamo.cestiamo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Campo")
public class Campo {
    @Id

    @Column(name = "ID_CAMPO", nullable = false)
    private Long id;

    @Column(name = "CITTA", length = 255)
    private String citta;

    @Column(name = "VIA", length = 255)
    private String via;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

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

}
