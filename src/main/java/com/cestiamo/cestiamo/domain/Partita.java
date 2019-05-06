package com.cestiamo.cestiamo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Partita")
public class Partita {
    @Id

    @Column(name = "ID_PARTITA", nullable = false)
    private Long id;

    @Column(name = "CAMPO", nullable = false)
    private Campo luogo;

    @Column(name = "DATA",  length = 16)
    private Date data;

    @Column(name = "ORARIO")
    private Time orario;

    @Column(name = "TIP_PART", nullable = false)
    private TipoPartita tipologia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData(){
        return data;
    }

    public void setData(Date data){
        this.data = data;
    }

    public Time getOrario() {
        return orario; }

    public void setOrario ( Time ora ){
        this.orario = ora;
    }


}
