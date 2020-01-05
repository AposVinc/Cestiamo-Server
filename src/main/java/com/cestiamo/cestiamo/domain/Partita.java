package com.cestiamo.cestiamo.domain;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "Partita")
public class Partita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARTITA" /* , nullable = false*/)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PARTITA" /*, nullable = false*/)
    private TipoPartita tipologia;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPO" /* , nullable = false*/)
    private Campo campo;

    @Column(name = "DATA")
    private LocalDateTime data;
/*
    @OneToMany(mappedBy = "Partita")
    private Set<Bacheca> bacheca = new HashSet<>();
*/

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="UTENTE_PARTITA",
            joinColumns={@JoinColumn(name="ID_PARTITA")},
            inverseJoinColumns={@JoinColumn(name="ID_UTENTE")})
    private Set<Utente> partecipanti = new HashSet<>();


    public Partita (){}

    public Partita (Campo campo, LocalDateTime data, TipoPartita tipologia, Set<Utente> partecipanti){
        this.campo = campo;
        this.data = data;
        this.tipologia = tipologia;
        this.partecipanti = partecipanti;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public LocalDateTime getData(){
        return data;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }

    public TipoPartita getTipologia(){
        return tipologia;
    }

    public void setTipologia(TipoPartita tipologia) {
        this.tipologia = tipologia;
    }

    public Set<Utente> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(Set<Utente> utentiPartecipanti) {
        this.partecipanti = utentiPartecipanti;
    }

    public void addPartecipante(Utente partecipante) {
        this.partecipanti.add(partecipante);
    }

    public void removePartecipante(Utente partecipante) {
        this.partecipanti.remove(partecipante);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partita partita = (Partita) o;
        return id.equals(partita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
