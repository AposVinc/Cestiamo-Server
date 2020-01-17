package com.cestiamo.cestiamo.controllers;

import com.cestiamo.cestiamo.business.BusinessException;
import com.cestiamo.cestiamo.business.impl.repositories.UtenteRepository;
//import com.cestiamo.cestiamo.Utility;
import com.cestiamo.cestiamo.business.impl.repositories.VotazioneRepository;
import com.cestiamo.cestiamo.domain.Partita;
import com.cestiamo.cestiamo.domain.Utente;
import com.cestiamo.cestiamo.domain.UtenteResponse;
import com.cestiamo.cestiamo.domain.Votazione;
import com.cestiamo.cestiamo.spring.security.JWTTokenUtil;
import com.cestiamo.cestiamo.spring.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private VotazioneRepository votazioneRepository;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin()
    @RequestMapping("/creaUtente")
    public String creaUtente(@RequestBody Utente u){
        try {
            Utente user=new Utente();        
            user.setNome((u.getNome()));
            user.setCognome((u.getCognome()));
            user.setEmail(u.getEmail());
            user.setCitta(u.getCitta());
            user.setVia(u.getVia());
            user.setPassword(passwordEncoder.encode(u.getPassword()));            
            user.setDataNascita((u.getDataNascita()));
            user.setImg(new byte[0]);
            utenteRepository.save(user);
            System.out.println(user);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return "Utente creato";
    }

    //@CrossOrigin()
    @RequestMapping("/getUtente")
    public List<Utente> getUtenti(){
        return  utenteRepository.findAll();
    }

    @GetMapping("/utente/{email}")
    public Utente findByEmail(@PathVariable String email){
        return utenteRepository.findUtenteByEmail(email);
    }

    //@CrossOrigin("*")
    @PostMapping("/login")
    public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);       
        response.setHeader(tokenHeader, token);
        return new UtenteResponse( ((UserDetailsImpl) userDetails).getUtente() );
    }

/*
    //@CrossOrigin("*")
    @PostMapping("/updateImage")
    public UtenteResponse updateImage(@RequestBody byte[] image){

        Utente  utente=  Utility.getUtente();
        try {
            utente.setImg(image);
            String s = new String(image);            
            utenteRepository.save(utente);
            String s1 = new String(utente.getImg());

        }catch (Exception ex){
            System.out.println(ex);
        }
        utente=Utility.getUtente();
        UtenteResponse u1=new UtenteResponse(utente);
        return u1;
    }
*/


    @CrossOrigin("*")
    @PostMapping("/updateUtente")
    public UtenteResponse updateProfilo(@RequestBody Utente utente) throws BusinessException{
        System.out.println("Entra nell update Profile");
        Utente u1=utenteRepository.findUtenteByEmail(utente.getEmail());
        u1.setNome(utente.getNome());
        u1.setCognome(utente.getCognome());
        u1.setEmail(utente.getEmail());
        u1.setDataNascita(utente.getDataNascita());
        utenteRepository.save(u1);
        UtenteResponse u=new UtenteResponse(u1);
        System.out.println("profilo aggiornato correttamente");
        return u;
    }


    static class NuovaVotazione {
        public Utente votante;
        public Utente votato;
        public int voto;
    }
    @CrossOrigin("*")
    @PostMapping("/votazione")
    public UtenteResponse votaUtente(@RequestBody NuovaVotazione nv){
        //unique sulle due ciavi e se presente modifica votazione esistente
        Votazione v = new Votazione(utenteRepository.findUtenteByEmail(nv.votante.getEmail()),utenteRepository.findUtenteByEmail(nv.votato.getEmail()),nv.voto);
        votazioneRepository.save(v);
        return new UtenteResponse(utenteRepository.findUtenteByEmail(nv.votato.getEmail()));
    }
}

