package com.cestiamo.cestiamo.domain;

import java.time.LocalDate;

public class UtenteResponse {

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String citta;
    private LocalDate dataNascita;
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
        this.mediaVoto=u.getMediaVoto();
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate d_nascita) {
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

    @Override
    public String toString() {
        return "UtenteResponse{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", citta='" + citta + '\'' +
                ", dataNascita=" + dataNascita +
                ", numPartite=" + numPartite +
                ", mediaVoto=" + mediaVoto +
                ", img='" + img + '\'' +
                '}';
    }
}
