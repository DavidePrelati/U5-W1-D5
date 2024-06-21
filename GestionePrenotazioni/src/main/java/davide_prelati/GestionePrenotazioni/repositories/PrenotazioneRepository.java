package davide_prelati.GestionePrenotazioni.repositories;

import davide_prelati.GestionePrenotazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    @Override
    List<Prenotazione> findAllById(Iterable<Long> longs);

    @Override
    List<Prenotazione> findAll();
}
