package com.cestiamo.cestiamo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "Votazione")
public class Votazione {

    @Embeddable
    public static class VotazioneId implements Serializable {
        @Column(name = "Votante")
        private Long votanteId;

        @Column(name = "Votato")
        private Long votatoId;

        public VotazioneId() {
        }

        public VotazioneId(Long votante, Long votato) {
            this.votanteId = votante;
            this.votatoId = votato;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VotazioneId that = (VotazioneId) o;
            return votanteId.equals(that.votanteId) &&
                    votatoId.equals(that.votatoId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(votanteId, votatoId);
        }
    }

    @EmbeddedId
    private VotazioneId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("votanteId")
    private Utente votante;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("votatoId")
    private Utente votato;

    @Column(name = "Voto")
    private int voto;

    private Votazione() {}

    public Votazione(Utente votante, Utente votato, int voto) {
        this.votante = votante;
        this.votato = votato;
        this.id = new VotazioneId(votante.getId(), votato.getId());
        this.voto = voto;
    }

    public Utente getVotante() {
        return votante;
    }

    public void setVotante(Utente votante) {
        this.votante = votante;
    }

    public Utente getVotato() {
        return votato;
    }

    public void setVotato(Utente votato) {
        this.votato = votato;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votazione votazione = (Votazione) o;
        return votante.equals(votazione.votante) &&
                votato.equals(votazione.votato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votante, votato);
    }
}