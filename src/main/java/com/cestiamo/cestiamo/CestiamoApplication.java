package com.cestiamo.cestiamo;

import com.cestiamo.cestiamo.business.impl.repositories.*;
import com.cestiamo.cestiamo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class CestiamoApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository, TipoPartitaRepository tipoPartitaRepository,
                                      CampoRepository campoRepository, PartitaRepository partitaRepository,
                                      VotazioneRepository votazioneRepository, MessaggioRepository messaggioRepository) {

		return (args) -> {
			try {
				Utente mrossi = new Utente();
				mrossi.setNome("Mario");
				mrossi.setCognome("Rossi");
				mrossi.setEmail("mario.rossi@mail.it");
				mrossi.setPassword(passwordEncoder.encode("123456789"));
				mrossi.setCitta("Roma");
				mrossi.setVia("Piazza Bologna, 17");
                mrossi.setDataNascita(LocalDate.of(1990,5,25));
				mrossi.setImg(new byte[0]);
				utenteRepository.save(mrossi);

				Utente gverdi = new Utente();
                gverdi.setNome("Giuseppe");
                gverdi.setCognome("Verdi");
                gverdi.setEmail("giuseppe.verdi@mail.it");
                gverdi.setPassword(passwordEncoder.encode("123456789"));
                gverdi.setCitta("Milano");
                gverdi.setVia("Via Aida, 80");
                gverdi.setDataNascita(LocalDate.of(1995,2,11));
                gverdi.setImg(new byte[0]);
				utenteRepository.save(gverdi);

				Utente aBianchi = new Utente();
				aBianchi.setNome("Antonio");
				aBianchi.setCognome("Bianchi");
				aBianchi.setEmail("antonio.bianchi@mail.it");
				aBianchi.setPassword(passwordEncoder.encode("123456789"));
				aBianchi.setCitta("Roma");
				aBianchi.setVia("Lungotevere Gianicolense, 257");
                aBianchi.setDataNascita(LocalDate.of(1980,6,5));
				aBianchi.setImg(new byte[0]);
				utenteRepository.save(aBianchi);

				Utente gMazzini = new Utente();
                gMazzini.setNome("Giuseppe");
                gMazzini.setCognome("Mazzini");
                gMazzini.setEmail("giuseppe.mazzini@mail.it");
                gMazzini.setPassword(passwordEncoder.encode("123456789"));
                gMazzini.setCitta("Milano");
                gMazzini.setVia("Piazza Duca d'Aosta, 94");
                gMazzini.setDataNascita(LocalDate.of(1969,12,30));
                gMazzini.setImg(new byte[0]);
				utenteRepository.save(gMazzini);

				Utente vapostolo = new Utente();
                vapostolo.setNome("Vincenzo");
                vapostolo.setCognome("Aposolo");
                vapostolo.setEmail("vincenzo.apostolo@mail.it");
                vapostolo.setPassword(passwordEncoder.encode("123456789"));
                vapostolo.setCitta("Avezzano");
                vapostolo.setVia("Australia, 44");
                vapostolo.setDataNascita(LocalDate.of(1995,11,4));
                vapostolo.setImg(new byte[0]);
				utenteRepository.save(vapostolo);

				Utente ffegatilli = new Utente();
                ffegatilli.setNome("Francesco");
                ffegatilli.setCognome("Fegatilli");
                ffegatilli.setEmail("francesco.fegatilli@mail.it");
                ffegatilli.setPassword(passwordEncoder.encode("123456789"));
                ffegatilli.setCitta("Celano");
                ffegatilli.setVia("Via Piccolomini, 80");
                ffegatilli.setDataNascita(LocalDate.of(1994,4,17));
                ffegatilli.setImg(new byte[0]);
				utenteRepository.save(ffegatilli);

				Utente ftotti = new Utente();
                ftotti.setNome("Francesco");
                ftotti.setCognome("Totti");
                ftotti.setEmail("francesco.totti@mail.it");
                ftotti.setPassword(passwordEncoder.encode("123456789"));
                ftotti.setCitta("Roma");
                ftotti.setVia("Lungotevere, 10");
                ftotti.setDataNascita(LocalDate.of(1970,6,5));
                ftotti.setImg(new byte[0]);
				utenteRepository.save(ftotti);

				Utente atomba = new Utente();
                atomba.setNome("Alberto");
                atomba.setCognome("Tomba");
                atomba.setEmail("alberto.tomba@mail.it");
                atomba.setPassword(passwordEncoder.encode("123456789"));
                atomba.setCitta("Bologna");
                atomba.setVia("Via Verdi, 94");
                atomba.setDataNascita(LocalDate.of(1966,12,19));
                atomba.setImg(new byte[0]);
				utenteRepository.save(atomba);

                System.out.println('\n' + "Utenti salvati"+'\n');
			} catch (Exception ex) {
				System.out.println("ERROR");
			}

            List<Utente> u = utenteRepository.findAll();

			try {
			    List<Votazione> votazioneList = new LinkedList<>() ;
			    votazioneList.add(new Votazione(u.get(0),u.get(1),5));
			    votazioneList.add(new Votazione(u.get(0),u.get(2),2));
			    votazioneList.add(new Votazione(u.get(0),u.get(3),3));
			    votazioneList.add(new Votazione(u.get(1),u.get(0),4));
			    votazioneList.add(new Votazione(u.get(1),u.get(2),1));
			    votazioneList.add(new Votazione(u.get(1),u.get(3),2));
			    votazioneList.add(new Votazione(u.get(2),u.get(0),5));
			    votazioneList.add(new Votazione(u.get(2),u.get(1),1));
			    votazioneList.add(new Votazione(u.get(3),u.get(2),3));
			    votazioneList.add(new Votazione(u.get(3),u.get(3),5));
			    votazioneList.add(new Votazione(u.get(3),u.get(4),5));
			    votazioneList.add(new Votazione(u.get(3),u.get(5),5));
			    votazioneList.add(new Votazione(u.get(3),u.get(6),5));
			    votazioneList.add(new Votazione(u.get(3),u.get(7),5));

                votazioneRepository.saveAll(votazioneList);

                System.out.println('\n' + "Voti salvati"+'\n');
            } catch (Exception ex) {
                System.out.println("ERROR");
            }

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
                c2.setVia("Via XX Settembre, 150");
                c2.setTelefono("347 2345678");

                Campo c3 = new Campo();
                c3.setCitta("L'Aquila");
                c3.setVia("Via Della Croce Rossa, 75");
                c3.setTelefono("328 4141250");

                Campo c4 = new Campo();
                c4.setCitta("Milano");
                c4.setVia("Via Roma, 23");
                c4.setTelefono("347 9525667");

                Campo c5 = new Campo();
                c5.setCitta("Chieti");
                c5.setVia("Via Verdi, 15");
                c5.setTelefono("347 23567786");

                Campo c6 = new Campo();
                c6.setCitta("Pescara");
                c6.setVia("Piazza Salotto, 43");
                c6.setTelefono("328 24516250");

                campoRepository.save(c1);
                campoRepository.save(c2);
                campoRepository.save(c3);
                campoRepository.save(c4);
                campoRepository.save(c5);
                campoRepository.save(c6);

                System.out.println('\n' + "Campi SALVATI" +'\n' );
            } catch (Exception ex) {
                System.out.println("ERROR");
            }

            List<Campo> c = campoRepository.findAll();

            try {
                Partita p1 = new Partita();
                p1.setCampo(c.get(0));
                p1.setData(LocalDateTime.of(2020,3,25,19,30));
                p1.setTipologia(t.get(0));
                partitaRepository.save(p1);

                Set<Utente> partecipantiP1 = new HashSet<>();
                partecipantiP1.add(u.get(1));
                partecipantiP1.add(u.get(3));
                p1.setPartecipanti(partecipantiP1);
                partitaRepository.save(p1);


                Partita p2 = new Partita();
                p2.setCampo(c.get(1));
                p2.setData(LocalDateTime.of(2020,5,12,18,0));
                p2.setTipologia(t.get(1));
                partitaRepository.save(p2);

                Set<Utente> partecipantiP2 = new HashSet<>();
                partecipantiP2.add(u.get(0));
                partecipantiP2.add(u.get(1));
                partecipantiP2.add(u.get(2));
                partecipantiP2.add(u.get(3));
                p2.setPartecipanti(partecipantiP2);
                partitaRepository.save(p2);


                Partita p3 = new Partita();
                p3.setCampo(c.get(1));
                p3.setData(LocalDateTime.of(2020,6,4,13,30));
                p3.setTipologia(t.get(1));
                partitaRepository.save(p3);

                Set<Utente> partecipantiP3 = new HashSet<>();
                partecipantiP3.add(u.get(0));
                partecipantiP3.add(u.get(1));
                partecipantiP3.add(u.get(2));
                p3.setPartecipanti(partecipantiP3);
                partitaRepository.save(p3);

                
                Partita p4 = new Partita();
                p4.setCampo(c.get(1));
                p4.setData(LocalDateTime.of(2020,1,4,18,0));
                p4.setTipologia(t.get(1));
                partitaRepository.save(p4);

                Set<Utente> partecipantiP4 = new HashSet<>();
                partecipantiP4.add(u.get(0));
                partecipantiP4.add(u.get(1));
                partecipantiP4.add(u.get(2));
                partecipantiP4.add(u.get(3));
                p4.setPartecipanti(partecipantiP4);
                partitaRepository.save(p4);


                Partita p5 = new Partita();
                p5.setCampo(c.get(2));
                p5.setData(LocalDateTime.of(2019,11,27,22,0));
                p5.setTipologia(t.get(1));
                partitaRepository.save(p5);

                Set<Utente> partecipantiP5 = new HashSet<>();
                partecipantiP5.add(u.get(0));
                partecipantiP5.add(u.get(1));
                partecipantiP5.add(u.get(2));
                partecipantiP5.add(u.get(3));
                p5.setPartecipanti(partecipantiP5);
                partitaRepository.save(p5);


                Partita p6 = new Partita();
                p6.setCampo(c.get(4));
                p6.setData(LocalDateTime.of(2019,8,7,18,0));
                p6.setTipologia(t.get(2));
                partitaRepository.save(p6);

                Set<Utente> partecipantiP6 = new HashSet<>();
                partecipantiP6.add(u.get(0));
                partecipantiP6.add(u.get(1));
                partecipantiP6.add(u.get(2));
                partecipantiP6.add(u.get(3));
                partecipantiP6.add(u.get(4));
                p6.setPartecipanti(partecipantiP6);
                partitaRepository.save(p6);


                Partita p7 = new Partita();
                p7.setCampo(c.get(5));
                p7.setData(LocalDateTime.of(2020,7,25,21,0));
                p7.setTipologia(t.get(4));
                partitaRepository.save(p7);

                Set<Utente> partecipantiP7 = new HashSet<>();
                partecipantiP7.add(u.get(0));
                partecipantiP7.add(u.get(1));
                partecipantiP7.add(u.get(2));
                partecipantiP7.add(u.get(3));
                partecipantiP7.add(u.get(4));
                partecipantiP7.add(u.get(5));
                p7.setPartecipanti(partecipantiP7);
                partitaRepository.save(p7);


                Partita p8 = new Partita();
                p8.setCampo(c.get(5));
                p8.setData(LocalDateTime.of(2020,5,13,14,0));
                p8.setTipologia(t.get(3));
                partitaRepository.save(p8);

                Set<Utente> partecipantiP8 = new HashSet<>();
                partecipantiP8.add(u.get(0));
                partecipantiP8.add(u.get(1));
                partecipantiP8.add(u.get(2));
                partecipantiP8.add(u.get(3));
                partecipantiP8.add(u.get(4));
                partecipantiP8.add(u.get(5));
                p8.setPartecipanti(partecipantiP8);
                partitaRepository.save(p8);

                System.out.println('\n' + "Partite SALVATE" +'\n');

            } catch (Exception ex) {
                System.out.println("ERROR");
            }

            List<Partita> p = partitaRepository.findAll();

            try {
                Messaggio m1 = new Messaggio();
                m1.setMittente(u.get(0));
                m1.setData(LocalDateTime.of(2020,1,4,10,3));
                m1.setTesto("Ciao, sono l'utente 1");
                m1.setPartita(p.get(1));

                Messaggio m2 = new Messaggio();
                m2.setMittente(u.get(1));
                m2.setData(LocalDateTime.of(2020,1,5,15,15));
                m2.setTesto("Ciao, sono l'utente 2");
                m2.setPartita(p.get(1));

                Messaggio m3 = new Messaggio();
                m3.setMittente(u.get(0));
                m3.setData(LocalDateTime.of(2020,1,5,16,56));
                m3.setTesto("utente 1");
                m3.setPartita(p.get(1));

                messaggioRepository.save(m1);
                messaggioRepository.save(m2);
                messaggioRepository.save(m3);

                Messaggio m4 = new Messaggio();
                m4.setMittente(u.get(1));
                m4.setData(LocalDateTime.of(2020,5,4,10,3));
                m4.setTesto("Ciao, ragazzi! Pronti per la partita?");
                m4.setPartita(p.get(2));

                Messaggio m5 = new Messaggio();
                m5.setMittente(u.get(0));
                m5.setData(LocalDateTime.of(2020,6,4,11,3));
                m5.setTesto("Ci vediamo tra poco!");
                m5.setPartita(p.get(2));

                messaggioRepository.save(m4);
                messaggioRepository.save(m5);

                Messaggio m6 = new Messaggio();
                m6.setMittente(u.get(1));
                m6.setData(LocalDateTime.of(2020,5,13,11,30));
                m6.setTesto("Pronti per oggi?");
                m6.setPartita(p.get(7));

                Messaggio m7 = new Messaggio();
                m7.setMittente(u.get(0));
                m7.setData(LocalDateTime.of(2020,5,13,13,00));
                m7.setTesto("A tra poco!");
                m7.setPartita(p.get(7));

                messaggioRepository.save(m6);
                messaggioRepository.save(m7);


                System.out.println('\n' + "Messaggi p2 SALVATE" +'\n');

            } catch (Exception ex) {
                System.out.println("ERROR");
            }

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CestiamoApplication.class, args);
	}

}
