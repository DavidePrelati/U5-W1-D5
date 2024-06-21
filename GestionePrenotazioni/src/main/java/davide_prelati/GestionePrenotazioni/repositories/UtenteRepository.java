package davide_prelati.GestionePrenotazioni.repositories;

import davide_prelati.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    List<Utente> findBySurname(String cognome);

    List<Utente> findByName(String nome);

    List<Utente> findByNameAndSurname(String nome, String cognome);

    List<Utente> findByNameIn(List<String> nomi);

}
