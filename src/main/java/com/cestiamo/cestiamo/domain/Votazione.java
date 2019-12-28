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

    @Enumerated(EnumType.STRING)
    private Voto voto;

    private Votazione() {}

    public Votazione(Utente votante, Utente votato, int voto) {
        this.votante = votante;
        this.votato = votato;
        this.id = new VotazioneId(votante.getId(), votato.getId());
        this.setVoto(voto);
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
        switch (this.voto){
            case UNO:
                return 1;
            case DUE:
                return 2;
            case TRE:
                return 3;
            case QUATTRO:
                return 4;
            case CINQUE:
                return 5;
            default:
                return 5;
        }
    }

    public void setVoto(int voto) {
        switch (voto){
            case 1:
                this.voto = Voto.UNO;
                break;
            case 2:
                this.voto = Voto.DUE;
                break;
            case 3:
                this.voto = Voto.TRE;
                break;
            case 4:
                this.voto = Voto.QUATTRO;
                break;
            case 5:
                this.voto = Voto.CINQUE;
                break;
            default:
                this.voto = Voto.CINQUE;
                break;
        }
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