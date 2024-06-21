package davide_prelati.GestionePrenotazioni.services;

import davide_prelati.GestionePrenotazioni.entities.Prenotazione;
import davide_prelati.GestionePrenotazioni.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione newPrenotazione) {
        prenotazioneRepository.save(newPrenotazione);
        log.info("Nuova prenotazione " + newPrenotazione.getId() + " salvata correttamente");
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id).orElse(null);
    }


    public void deletePrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
        log.info("Prenotazione con id " + id + " eliminata correttamente");
    }
}
