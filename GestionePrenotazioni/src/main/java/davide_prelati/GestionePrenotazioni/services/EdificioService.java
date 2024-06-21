package davide_prelati.GestionePrenotazioni.services;

import davide_prelati.GestionePrenotazioni.entities.Edificio;
import davide_prelati.GestionePrenotazioni.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;


    public void saveEdificio(Edificio newEdificio) {
        edificioRepository.save(newEdificio);
        log.info("Nuovo edificio " + newEdificio.getNome() + " salvato con successo");
    }

    public List<Edificio> getAllEdifici() {
        return edificioRepository.findAll();
    }

    public Edificio getEdificioById(Long id) {
        return edificioRepository.findById(id).orElse(null);
    }


    public void deleteEdificio(Long id) {
        edificioRepository.deleteById(id);
        log.info("Edificio con id " + id + " eliminato correttamente");
    }
}
