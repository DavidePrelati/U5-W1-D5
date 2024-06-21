package davide_prelati.GestionePrenotazioni.repositories;

import davide_prelati.GestionePrenotazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    @Query("SELECT p FROM Prenotazione p WHERE p.postazione.id = :postazioneId AND p.data = :data")
    List<Prenotazione> findByPostazioneAndData(@Param("postazioneId") Long postazioneId, @Param("data") LocalDate data);
}
