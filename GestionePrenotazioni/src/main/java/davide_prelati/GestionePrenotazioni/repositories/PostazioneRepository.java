package davide_prelati.GestionePrenotazioni.repositories;


import davide_prelati.GestionePrenotazioni.entities.Postazione;
import davide_prelati.GestionePrenotazioni.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByDescription(String descrizione);

    List<Postazione> findAllByType(Tipo tipo);
}
