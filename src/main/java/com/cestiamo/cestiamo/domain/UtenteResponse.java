package com.cestiamo.cestiamo.domain;

import java.util.Date;

public class UtenteResponse {

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String citta;
    private Date dataNascita;
    private int numPartite;
    private int mediaVoto;
    private String img;

    public UtenteResponse() {
    }

    public UtenteResponse(Utente u){
        this.nome=u.getNome();
        this.cognome=u.getCognome();
        this.email=u.getEmail();
        this.password=u.getPassword();
        this.citta=u.getCitta();
        this.dataNascita=u.getDataNascita();
        this.numPartite=u.getNumPartite();
        this.img=new String(u.getImg());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date d_nascita) {
        this.dataNascita = d_nascita;
    }

    public int getMediaVoto() {
        return mediaVoto;
    }

    public int getNumPartite(){
        return numPartite;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
