package davide_prelati.GestionePrenotazioni.services;

import davide_prelati.GestionePrenotazioni.entities.Utente;
import davide_prelati.GestionePrenotazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente(Utente newUtente) {
        utenteRepository.save(newUtente);
        log.info("Nuovo utente " + newUtente.getNome() + "salvato con successo");
    }

    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(Long id) {
        return utenteRepository.findById(id).orElse(null);
    }
    
    public void deleteUtente(Long id) {
        utenteRepository.deleteById(id);
        log.info("Utente con id " + id + " eliminato correttamente");
    }
}
