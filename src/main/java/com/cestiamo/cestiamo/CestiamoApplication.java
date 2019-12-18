package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.business.impl.repositories.*;
import com.cestiamo.cestiamo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@SpringBootApplication
public class CestiamoApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository, TipoPartitaRepository tipoPartitaRepository, CampoRepository campoRepository, PartitaRepository partitaRepository) {

		return (args) -> {
			try {
				Utente mrossi = new Utente();
				mrossi.setNome("Mario");
				mrossi.setCognome("Rossi");
				mrossi.setEmail("mario.rossi@mail.it");
				mrossi.setPassword(passwordEncoder.encode("123456789"));
				mrossi.setCitta("Roma");
                mrossi.setD_nascita(new GregorianCalendar(1990, Calendar.MARCH,25).getTime());// day of month salva 24 in DB
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

            try {
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

                System.out.println("CREATI tipi partita");

                tipoPartitaRepository.save(unovsuno);
                tipoPartitaRepository.save(duevsdue);
                tipoPartitaRepository.save(trevstre);
                tipoPartitaRepository.save(quattrovsquattro);
                tipoPartitaRepository.save(cinquevscinque);

                System.out.println("SALVATI tipi partita");
            } catch (Exception ex) {
                System.out.println("ERROR");
            }
            System.out.println("Tipi Partita salvati"+'\n');


            try {
                Campo c1 = new Campo();
                c1.setCitta("Roma");
                c1.setVia("Via dei Tulipani, 2");
                c1.setTelefono("347 1234567");

                Campo c2 = new Campo();
                c2.setCitta("Avezzano");
                c2.setVia("Via XX Settempre, 150");
                c2.setTelefono("347 2345678");

                Campo c3 = new Campo();
                c3.setCitta("L'Aquila");
                c3.setVia("Via Della Croce Rossa, 75");
                c3.setTelefono("328 4141250");

                System.out.println("CREATI campi ");

                campoRepository.save(c1);
                campoRepository.save(c2);
                campoRepository.save(c3);

                System.out.println("SALVATI ");
            } catch (Exception ex) {
                System.out.println("ERROR");
            }
            System.out.println("salvati"+'\n');


            List<Campo> c = campoRepository.findAll();
            List<TipoPartita> t = tipoPartitaRepository.findAll();
            try {
                Partita p1 = new Partita();
                p1.setCampo(c.get(0));
                p1.setData(new GregorianCalendar(2019, Calendar.NOVEMBER,25,22,15).getTime());
                p1.setTipologia(t.get(0));

                Partita p2 = new Partita();
                p2.setCampo(c.get(1));
                p2.setData(new GregorianCalendar(2019, Calendar.OCTOBER,14,19,12).getTime());
                p2.setTipologia(t.get(1));

                Partita p3 = new Partita();
                p3.setCampo(c.get(1));
                p3.setData(new GregorianCalendar(2020, Calendar.MARCH,30,19,12).getTime());
                p3.setTipologia(t.get(4));

                System.out.println("CREATI ");

                partitaRepository.save(p1);
                partitaRepository.save(p2);
                partitaRepository.save(p3);

                System.out.println("SALVATI ");
            } catch (Exception ex) {
                System.out.println("ERROR");
            }
            System.out.println("salvati"+'\n');




		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CestiamoApplication.class, args);
	}

}
