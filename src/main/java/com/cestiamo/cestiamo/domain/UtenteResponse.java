package com.cestiamo.cestiamo.domain;

public class UtenteResponse {


    private Long id;
    private String nome;
    private String cognome;
    private String d_nascita;
    private String email;
    private String password;
    private String img;

    public UtenteResponse() {
    }

    public UtenteResponse(Utente u){
        this.id=u.getId_utente();
        this.nome=u.getNome();
        this.cognome=u.getCognome();
        //this.d_nascita=u.getD_nascita();
        this.email=u.getEmail();
        this.password=u.getPassword();
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

    public String getD_nascita() {
        return d_nascita;
    }

    public void setD_nascita(String d_nascita) {
        this.d_nascita = d_nascita;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "id_utente=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", d_nascita=" + d_nascita +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
