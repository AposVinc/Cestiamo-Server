package com.cestiamo.cestiamo.domain;

import java.util.Date;

public class PartitaResponse {
    private Campo campo;
    private Date data;
    private TipoPartita tipologia;


    public PartitaResponse(Campo luogo1, Date data1, TipoPartita tipologia1){
        this.campo = luogo1;
        this.data = data1;
        this.tipologia = tipologia1;
    }

    public PartitaResponse(Partita p){
        this.campo = p.getCampo();
        this.data = p.getData();
        this.tipologia = p.getTipologia();
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
