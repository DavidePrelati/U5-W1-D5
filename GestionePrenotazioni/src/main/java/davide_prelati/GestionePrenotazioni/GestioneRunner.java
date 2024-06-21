package davide_prelati.GestionePrenotazioni;

import davide_prelati.GestionePrenotazioni.entities.Edificio;
import davide_prelati.GestionePrenotazioni.entities.Postazione;
import davide_prelati.GestionePrenotazioni.entities.Prenotazione;
import davide_prelati.GestionePrenotazioni.entities.Utente;
import davide_prelati.GestionePrenotazioni.enums.Tipo;
import davide_prelati.GestionePrenotazioni.services.EdificioService;
import davide_prelati.GestionePrenotazioni.services.PostazioneService;
import davide_prelati.GestionePrenotazioni.services.PrenotazioneService;
import davide_prelati.GestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class GestioneRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        Edificio edificio1 = new Edificio();
        edificio1.setNome("VivaTickets");
        edificio1.setIndirizzo("Via Tran, 1");
        edificio1.setCitta("Roma");
        edificioService.saveEdificio(edificio1);

        Edificio edificio2 = new Edificio();
        edificio2.setNome("VivaEvents");
        edificio2.setIndirizzo("Via Carlo, 24");
        edificio2.setCitta("Milano");
        edificioService.saveEdificio(edificio2);


        Postazione postazione1 = new Postazione();
        postazione1.setDescrizione("Postazione Privata 1");
        postazione1.setTipo(Tipo.PRIVATO);
        postazione1.setMax_occupanti(2);
        postazione1.setEdificio(edificio1);
        postazioneService.savePostazione(postazione1);

        Postazione postazione2 = new Postazione();
        postazione2.setDescrizione("Postazione Openspace 1");
        postazione2.setTipo(Tipo.OPENSPACE);
        postazione2.setMax_occupanti(4);
        postazione2.setEdificio(edificio2);
        postazioneService.savePostazione(postazione2);


        Utente utente1 = new Utente();
        utente1.setNome("Franco");
        utente1.setCognome("Franchi");
        utente1.setEmail("franco.franchi@gmail.com");
        utenteService.saveUtente(utente1);

        Utente utente2 = new Utente();
        utente2.setNome("Igor");
        utente2.setCognome("Miti");
        utente2.setEmail("igor.miti@gmail.com");
        utenteService.saveUtente(utente2);

        // Creazione di prenotazioni di esempio
        LocalDate date1 = LocalDate.of(2024, 11, 22);

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setData(date1);
        prenotazione1.setUtente(utente1);
        prenotazione1.setPostazione(postazione1);
        prenotazioneService.savePrenotazione(prenotazione1);

        LocalDate date2 = LocalDate.of(2024, 6, 25);

        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setData(date2);
        prenotazione2.setUtente(utente2);
        prenotazione2.setPostazione(postazione2);
        prenotazioneService.savePrenotazione(prenotazione2);

        List<Postazione> postazioni = postazioneService.findByTipoAndCitta(Tipo.PRIVATO, "Roma");
        postazioni.forEach(postazione -> {
            System.out.println("Postazione trovata con successo: " + postazione.getDescrizione());
        });
    }

}
