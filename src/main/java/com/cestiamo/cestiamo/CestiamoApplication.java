package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.business.impl.repositories.UtenteRepository;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.TipoPartita;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class CestiamoApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository) {
		return (args) -> {
			Utente mrossi = new Utente();
			mrossi.setNome("Mario");
			mrossi.setCognome("Rossi");
			mrossi.setEmail("aaa.aa@aaa.it");
			mrossi.setPassword(passwordEncoder.encode("Mario"));
			mrossi.setCitta("Roma");
			mrossi.setD_nascita(new Date(System.currentTimeMillis() + (20 * 86400000)));
			mrossi.setN_partita(11); //si eve calcolare le occorrenze tra utente e partite
			mrossi.setVoto_m(4);

			System.out.println("CREATO");
			System.out.println(mrossi);
			//utenteRepository.save(mrossi);
			System.out.println("SALVATO");

			TipoPartita unovsuno = new TipoPartita();
			unovsuno.setNome("1vs1");
			unovsuno.setN_giocatori(2);

			Partita partita = new Partita();
			partita.setTipologia(unovsuno);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(CestiamoApplication.class, args);
	}

}
