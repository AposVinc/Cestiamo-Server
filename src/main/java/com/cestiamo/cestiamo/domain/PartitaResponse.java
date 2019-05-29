package com.cestiamo.cestiamo.domain;

import java.sql.Date;
import java.sql.Time;

public class PartitaResponse {
    private Campo luogo;
    private Date data;
    private Time orario;
    private TipoPartita tipologia;


    public PartitaResponse(Campo luogo1, Date data1, Time orario1, TipoPartita tipologia1){
        this.luogo = luogo1;
        this.data = data1;
        this.orario = orario1;
        this.tipologia = tipologia1;
    }

    public PartitaResponse(Partita p){
        this.luogo = p.getLuogo();
        this.data = p.getData();
        this.orario = p.getOrario();
        this.tipologia = p.getTipologia();
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
