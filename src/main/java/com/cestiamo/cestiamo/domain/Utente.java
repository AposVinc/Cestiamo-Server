package com.cestiamo.cestiamo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UTENTE", nullable = false)
	private Long id;

	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;

	@Column(name = "COGNOME", nullable = false, length = 255)
	private String cognome;

	@Column(name = "EMAIL", nullable = false, length = 255)
	private String email;

	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;

	@Column(name = "CITTA", length = 255)
	private String citta;

	@Column(name = "NASCITA",  length = 16)
	private Date d_nascita;

	@Column(name = "N_PARTITA", length = 255)
	private int n_partita;

	@Column(name = "VOTO_M",  length = 255)
	private int voto_m;

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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utente)) return false;
		Utente utente = (Utente) o;
		return id.equals(utente.id);
	}

	/*
	@Override
	public int hashCode() {
		return Objects.hash(id, getFamiglia());
	}

	 */
}
