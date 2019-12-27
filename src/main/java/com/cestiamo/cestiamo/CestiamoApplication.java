package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.business.impl.repositories.*;
import com.cestiamo.cestiamo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

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
				mrossi.setVia("Piazza Bologna, 17");
                mrossi.setD_nascita(new GregorianCalendar(1990, Calendar.MARCH,25).getTime());// day of month salva 24 in DB
                //mrossi.setN_partita(11); //si eve calcolare le occorrenze tra utente e partite
				//mrossi.setVoto_m(4);
				mrossi.setImg(new byte[0]);
				utenteRepository.save(mrossi);
				System.out.println("SALVATO Mario Rossi");

				Utente gverdi = new Utente();
                gverdi.setNome("Giuseppe");
                gverdi.setCognome("Verdi");
                gverdi.setEmail("giuseppe.verdi@mail.it");
                gverdi.setPassword(passwordEncoder.encode("123456789"));
                gverdi.setCitta("Milano");
                gverdi.setVia("Via dei Piccolomini, 80");
                gverdi.setD_nascita(new GregorianCalendar(1995, Calendar.FEBRUARY,11).getTime());// day of month salva 24 in DB
                //gverdi.setN_partita(1); //si eve calcolare le occorrenze tra utente e partite
                //gverdi.setVoto_m(5);
                gverdi.setImg(new byte[0]);
				utenteRepository.save(gverdi);
				System.out.println("SALVATO Giuseppe Verdi");

				Utente aBianchi = new Utente();
				aBianchi.setNome("Antonio");
				aBianchi.setCognome("Bianchi");
				aBianchi.setEmail("antonio.bianchi@mail.it");
				aBianchi.setPassword(passwordEncoder.encode("123456789"));
				aBianchi.setCitta("Roma");
				aBianchi.setVia("Lungotevere Gianicolense, 257");
                aBianchi.setD_nascita(new GregorianCalendar(1980, Calendar.JULY,5).getTime());// day of month salva 24 in DB
                //aBianchi.setN_partita(6); //si eve calcolare le occorrenze tra utente e partite
				//aBianchi.setVoto_m(3);
				aBianchi.setImg(new byte[0]);
				utenteRepository.save(aBianchi);
				System.out.println("SALVATO Antonio Bianchi");

				Utente gMazzini = new Utente();
                gMazzini.setNome("Giuseppe");
                gMazzini.setCognome("Mazzini");
                gMazzini.setEmail("giuseppe.mazzini@mail.it");
                gMazzini.setPassword(passwordEncoder.encode("123456789"));
                gMazzini.setCitta("Milano");
                gMazzini.setVia("Piazza Duca d'Aosta, 94");
                gMazzini.setD_nascita(new GregorianCalendar(1969, Calendar.DECEMBER,30).getTime());// day of month salva 24 in DB
                //gMazzini.setN_partita(0); //si eve calcolare le occorrenze tra utente e partite
                //gMazzini.setVoto_m(0);
                gMazzini.setImg(new byte[0]);
				utenteRepository.save(gMazzini);
				System.out.println("SALVATO Giuseppe Mazzini");

                System.out.println('\n' + "Utenti salvati"+'\n');
			} catch (Exception ex) {
				System.out.println("ERROR");
			}

            List<Utente> u = utenteRepository.findAll();

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

                tipoPartitaRepository.save(unovsuno);
                tipoPartitaRepository.save(duevsdue);
                tipoPartitaRepository.save(trevstre);
                tipoPartitaRepository.save(quattrovsquattro);
                tipoPartitaRepository.save(cinquevscinque);

                System.out.println('\n' + "SALVATI tipi partita" +'\n' );
            } catch (Exception ex) {
                System.out.println("ERROR");
            }

            List<TipoPartita> t = tipoPartitaRepository.findAll();

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

                campoRepository.save(c1);
                campoRepository.save(c2);
                campoRepository.save(c3);

                System.out.println('\n' + "Campi SALVATI" +'\n' );
            } catch (Exception ex) {
                System.out.println("ERROR");
            }

            List<Campo> c = campoRepository.findAll();

            try {
                Partita p1 = new Partita();
                p1.setCampo(c.get(0));
                p1.setData(new GregorianCalendar(2019, Calendar.NOVEMBER,25,22,15).getTime());
                p1.setTipologia(t.get(0));
                p1.addPartecipante(u.get(1));
                p1.addPartecipante(u.get(3));

                Partita p2 = new Partita();
                p2.setCampo(c.get(1));
                p2.setData(new GregorianCalendar(2019, Calendar.OCTOBER,14,19,12).getTime());
                p2.setTipologia(t.get(1));
                p2.addPartecipante(u.get(0));
                p2.addPartecipante(u.get(1));
                p2.addPartecipante(u.get(2));
                p2.addPartecipante(u.get(3));

                Partita p3 = new Partita();
                p3.setCampo(c.get(1));
                p3.setData(new GregorianCalendar(2020, Calendar.MARCH,30,19,12).getTime());
                p3.setTipologia(t.get(1));;
                p3.addPartecipante(u.get(0));
                p3.addPartecipante(u.get(1));
                p3.addPartecipante(u.get(2));
                p3.addPartecipante(u.get(3));

                partitaRepository.save(p1);
                partitaRepository.save(p2);
                partitaRepository.save(p3);

                System.out.println('\n' + "Partite SALVATE" +'\n');

            } catch (Exception ex) {
                System.out.println("ERROR");
            }

            List<Partita> p = partitaRepository.findAll();
/*
            System.out.println('\n' + "**********" +'\n');
            Set<Utente> utenteSet = p.get(0).getPartecipanti();
            for (Utente utente: utenteSet){
                System.out.println(utente.toString());
            }
            //for (Utente utente : p.get(0).getPartecipanti()) System.out.println(utente.toString());

            //System.out.println(u.get(0).getPartite_giocate());
            System.out.println('\n' + "**********" +'\n');
*/
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CestiamoApplication.class, args);
	}

}
