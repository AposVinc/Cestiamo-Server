package com.cestiamo.cestiamo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Utente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UTENTE", nullable = false)
	private Long id;

	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;

	@Column(name = "COGNOME", nullable = false, length = 255)
	private String cognome;

	@Column(name = "EMAIL", nullable = false, length = 255, unique = true)
	private String email;

	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;

	@Column(name = "CITTA", length = 255)
	private String citta;

	@Column(name = "NASCITA",  length = 16)
	private Date dataNascita;

	@JsonIgnore
	@ManyToMany(mappedBy = "partecipanti")
	private Set<Partita> partiteGiocate = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "votante",
				cascade = CascadeType.ALL,
				orphanRemoval = true)
	private Set<Votazione> votazioniFatte = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "votato",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Votazione> votazioniRicevute = new HashSet<>();

	@Lob
	@Column(name="IMG")
	private byte[] img;


	public Long getId_utente() { return id;	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public Set<Partita> getPartiteGiocate() { return partiteGiocate; }

	public void setPartiteGiocate(Set<Partita> partite_giocate) {
		this.partiteGiocate = partite_giocate;
	}

	public void addPartitaGiocata(Partita partita){
		this.partiteGiocate.add(partita);
	}
	
	public int getNumPartite() {
		return partiteGiocate.size();
	}

	public Set<Votazione> getVotazioniFatte() {
		return votazioniFatte;
	}

	public void setVotazioniFatte(Set<Votazione> votazioni_fatte) {
		this.votazioniFatte = votazioni_fatte;
	}

	public void addVotazioneUtente(Utente votato, int voto) {
		this.votazioniFatte.add(new Votazione(this, votato, voto));
	}

	public Set<Votazione> getVotazioniRicevute() {
		return votazioniRicevute;
	}

	public void setVotazioniRicevute(Set<Votazione> votazioni_ricevute) {
		this.votazioniRicevute = votazioni_ricevute;
	}
	
	public int getMediaVoto(){
		int tot = 0;
		for (Votazione v: votazioniRicevute) {
			tot += v.getVoto();
		}
		return tot/votazioniRicevute.size();
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utente)) return false;
		Utente utente = (Utente) o;
		return id.equals(utente.id);
	}

}
