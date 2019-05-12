package com.cestiamo.cestiamo.domain;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "Partita")
public class Partita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARTITA", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPO", nullable = false)
    private Campo luogo;

    @Column(name = "DATA")
    private Date data;

    @Column(name = "ORARIO")
    private Time orario;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PARTITA", nullable = false)
    private TipoPartita tipologia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Campo getLuogo() {
        return luogo;
    }

    public void setLuogo(Campo luogo) {
        this.luogo = luogo;
    }

    public Date getData(){
        return data;
    }

    public void setData(Date data){
        this.data = data;
    }

    public Time getOrario() {
        return orario;
    }

    public void setOrario ( Time ora ) {
        this.orario = ora;
    }

    public TipoPartita getTipologia(){
        return tipologia;
    }

    public void setTipologia(TipoPartita tipologia) {
        this.tipologia = tipologia;
    }


}
