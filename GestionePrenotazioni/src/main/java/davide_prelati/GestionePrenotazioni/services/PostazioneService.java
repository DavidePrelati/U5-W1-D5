package davide_prelati.GestionePrenotazioni.services;

import davide_prelati.GestionePrenotazioni.entities.Postazione;
import davide_prelati.GestionePrenotazioni.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void savePostazione(Postazione newPostazione) {
        postazioneRepository.save(newPostazione);
        log.info("Nuova postazione " + newPostazione.getDescrizione() + " salvata con successo");
    }

    public List<Postazione> getAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public Postazione getPostazioneById(Long id) {
        return postazioneRepository.findById(id).orElse(null);
    }

    public void deletePostazione(Long id) {
        postazioneRepository.deleteById(id);
        log.info("Postazione con id " + id + " eliminata correttamente");
    }
}
