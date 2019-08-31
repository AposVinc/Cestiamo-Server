package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.business.impl.repositories.*;
import com.cestiamo.cestiamo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication
public class CestiamoApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository, TipoPartitaRepository tipoPartitaRepository, CampoRepository campoRepository, PartitaRepository partitaRepository) {

		return (args) -> {

			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

			try {
				Utente mrossi = new Utente();
				mrossi.setNome("Mario");
				mrossi.setCognome("Rossi");
				mrossi.setEmail("aaa.aa@aaa.it");
				mrossi.setPassword(passwordEncoder.encode("123456789"));
				mrossi.setCitta("Roma");
				mrossi.setD_nascita(formatter.format(new GregorianCalendar(1990, Calendar.JULY, 21).getTime()));
				mrossi.setN_partita(11); //si eve calcolare le occorrenze tra utente e partite
				mrossi.setVoto_m(4);
				mrossi.setImg(new byte[0]);
				System.out.println("CREATO Mario Rossi");
				utenteRepository.save(mrossi);
				System.out.println("SALVATO Mario Rossi");
			} catch (Exception ex) {
				System.out.println("ERROR");
			}
			System.out.println("Utenti salvati"+'\n');


			TipoPartita unovsuno = new TipoPartita();
			unovsuno.setNome(EnumTipoP.UNOvUNO.label);
			unovsuno.setN_giocatori(2);

			TipoPartita duevsdue = new TipoPartita();
			duevsdue.setNome(EnumTipoP.DUEvsDUE.label);
			duevsdue.setN_giocatori(4);

			TipoPartita trevstre = new TipoPartita();
			trevstre.setNome(EnumTipoP.TREvsTRE.label);
			trevstre.setN_giocatori(6);

			TipoPartita quattrovsquattro = new TipoPartita();
			quattrovsquattro.setNome(EnumTipoP.QUATTROvsQUATTRO.label);
			quattrovsquattro.setN_giocatori(8);

			TipoPartita cinquevscinque = new TipoPartita();
			cinquevscinque.setNome(EnumTipoP.CINQUEvsCINQUE.label);
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
