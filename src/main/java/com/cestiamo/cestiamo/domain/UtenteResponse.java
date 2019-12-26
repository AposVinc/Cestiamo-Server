package com.cestiamo.cestiamo.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class UtenteResponse {

    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String citta;
    private Date d_nascita;
    private String img;

    public UtenteResponse() {
    }

    public UtenteResponse(Utente u){
        this.id=u.getId_utente();
        this.nome=u.getNome();
        this.cognome=u.getCognome();
        this.email=u.getEmail();
        this.password=u.getPassword();
        this.citta=u.getCitta();
        this.d_nascita=u.getD_nascita();
        this.img=new String(u.getImg());
    }


    public Long getId_utente() {
        return id;
    }

    public void setId_utente(Long id) {
        this.id = id;
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

    public Date getD_nascita() {
        return d_nascita;
    }

    public void setD_nascita(Date d_nascita) {
        this.d_nascita = d_nascita;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", città=" + citta +
                ", data di nascita=" + d_nascita +
                ", img='" + img + '\'' +
                '}';
    }
}
