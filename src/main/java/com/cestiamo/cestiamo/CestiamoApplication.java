package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.business.impl.repositories.UtenteRepository;
import com.cestiamo.cestiamo.domain.Utente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CestiamoApplication {

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository) {
		return (args) -> {
			Utente mrossi = new Utente();
			mrossi.setNome("Mario");
			mrossi.setCognome("Rossi");
			mrossi.setEmail("aaa.aa@aaa.it");
			mrossi.setPassword("Mario");
			mrossi.setCitta("Roma");
			mrossi.setD_nascita(new Date(System.currentTimeMillis() + (20 * 86400000)));
			mrossi.setN_partita(11); //si eve calcolare le occorrenze tra utente e partite
			mrossi.setVoto_m(4);

			utenteRepository.save(mrossi);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(CestiamoApplication.class, args);
	}

}
