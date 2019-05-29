package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.business.impl.repositories.CampoRepository;
import com.cestiamo.cestiamo.business.impl.repositories.PartitaRepository;
import com.cestiamo.cestiamo.business.impl.repositories.TipoPartitaRepository;
import com.cestiamo.cestiamo.business.impl.repositories.UtenteRepository;
import com.cestiamo.cestiamo.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.sql.Date;
import java.util.Calendar;

@SpringBootApplication
public class CestiamoApplication {

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository, TipoPartitaRepository tipoPartitaRepository, CampoRepository campoRepository, PartitaRepository partitaRepository) {
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


			TipoPartita unovsuno = new TipoPartita();
			unovsuno.setNome(EnumTipoP.UNOvUNO);
			unovsuno.setN_giocatori(2);

			TipoPartita duevsdue = new TipoPartita();
			duevsdue.setNome(EnumTipoP.DUEvsDUE);
			duevsdue.setN_giocatori(4);

			TipoPartita trevstre = new TipoPartita();
			trevstre.setNome(EnumTipoP.TREvsTRE);
			trevstre.setN_giocatori(6);

			TipoPartita quattrovsquattro = new TipoPartita();
			quattrovsquattro.setNome(EnumTipoP.QUATTROvsQUATTRO);
			quattrovsquattro.setN_giocatori(8);

			TipoPartita cinquevscinque = new TipoPartita();
			cinquevscinque.setNome(EnumTipoP.CINQUEvsCINQUE);
			cinquevscinque.setN_giocatori(10);

			tipoPartitaRepository.save(unovsuno);
			tipoPartitaRepository.save(duevsdue);
			tipoPartitaRepository.save(trevstre);
			tipoPartitaRepository.save(quattrovsquattro);
			tipoPartitaRepository.save(cinquevscinque);


			Campo c1 = new Campo();
			c1.setCitta("Roma");
			c1.setVia("via dei tulipani, 2");
			c1.setTelefono("3471234567");

			Campo c2 = new Campo();
			c2.setCitta("Avezzano");
			c2.setVia("via XX settempre, 150");
			c2.setTelefono("3472345678");

			campoRepository.save(c1);
			campoRepository.save(c2);


			Partita p1 = new Partita();
			p1.setLuogo(c1);
			Date dataPartita1 = new Date(System.currentTimeMillis());
			p1.setData(dataPartita1);
			Time orarioPartita1 = new Time(22,30,0);	//viene salvata 1h in meno
			p1.setOrario(orarioPartita1);
			p1.setTipologia(unovsuno);

			Partita p2 = new Partita();
			p2.setLuogo(c2);
			Date dataPartita2 = new Date(System.currentTimeMillis());
			p2.setData(dataPartita2);
			Time orarioPartita2 = new Time(22,0,0);		//viene salvata 1h in meno
			p2.setOrario(orarioPartita2);
			p2.setTipologia(unovsuno);

			partitaRepository.save(p1);
			partitaRepository.save(p2);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CestiamoApplication.class, args);
	}

}
