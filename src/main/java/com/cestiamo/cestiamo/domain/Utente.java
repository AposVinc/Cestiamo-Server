package com.cestiamo.cestiamo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utente")
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
	private Date d_nascita;

	@JsonIgnore
	@ManyToMany(mappedBy = "partecipanti")
	private Set<Partita> partiteGiocate = new HashSet<>();

	// n° partite giocate

	@OneToMany(mappedBy = "votante",
				cascade = CascadeType.ALL,
				orphanRemoval = true)
	private Set<Votazione> votazioni_fatte = new HashSet<>();


	@OneToMany(mappedBy = "votato",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Votazione> votazioni_ricevute = new HashSet<>();

	// media voto

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

	public Date getD_nascita() {
		return d_nascita;
	}

	public void setD_nascita(Date d_nascita) {
		this.d_nascita = d_nascita;
	}

	public Set<Partita> getPartiteGiocate() { return partiteGiocate; }

	public void addPartitaGiocata(Partita partita){
		this.partiteGiocate.add(partita);
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utente)) return false;
		Utente utente = (Utente) o;
		return id.equals(utente.id);
	}

}
