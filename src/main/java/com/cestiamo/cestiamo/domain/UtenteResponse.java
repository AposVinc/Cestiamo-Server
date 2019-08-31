package com.cestiamo.cestiamo.domain;

public class UtenteResponse {

    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String citta;
    private String d_nascita;
    private int n_partita;
    private int voto_m;
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
        this.n_partita=u.getN_partita();
        this.voto_m=u.getVoto_m();
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

    public String getD_nascita() {
        return d_nascita;
    }

    public void setD_nascita(String d_nascita) {
        this.d_nascita = d_nascita;
    }

    public int getN_partita() {
        return n_partita;
    }

    public void setN_partita(int n_partita) {
        this.n_partita = n_partita;
    }

    public int getVoto_m() {
        return voto_m;
    }

    public void setVoto_m(int voto_m) {this.voto_m = voto_m;}

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
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", città=" + citta +
                ", data di nascita=" + d_nascita +
                ", numero partite=" + n_partita +
                ", voto=" + voto_m +
                ", img='" + img + '\'' +
                '}';
    }
}
