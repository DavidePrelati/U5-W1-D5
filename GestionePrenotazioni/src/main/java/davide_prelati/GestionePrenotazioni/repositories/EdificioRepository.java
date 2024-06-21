package davide_prelati.GestionePrenotazioni.repositories;

import davide_prelati.GestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    @Override
    List<Edificio> findAll();

    List<Edificio> findByName(String nome);

    List<Edificio> findByCitta(String citta);

    List<Edificio> findByIndirizzo(String indirizzo);

    List<Edificio> findByNameIn(List<String> nomi);

    @Override
    List<Edificio> findAllById(Iterable<Long> longs);
}
