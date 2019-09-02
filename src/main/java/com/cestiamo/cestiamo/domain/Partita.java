package com.cestiamo.cestiamo.domain;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Partita")
public class Partita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARTITA", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPO", nullable = false)
    private Campo campo;

    @Column(name = "DATA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PARTITA", nullable = false)
    private TipoPartita tipologia;

    @OneToMany(mappedBy = "partita")
    private Set<Bacheca> bachecas = new HashSet<Bacheca>();

    public Partita (){}

    public Partita (Campo campo, Date data, TipoPartita tipologia){
        this.campo = campo;
        this.data = data;
        this.tipologia = tipologia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public Date getData(){
        return data;
    }

    public void setData(Date data){
        this.data = data;
    }

    public TipoPartita getTipologia(){
        return tipologia;
    }

    public void setTipologia(TipoPartita tipologia) {
        this.tipologia = tipologia;
    }


}
