package davide_prelati.GestionePrenotazioni.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String indirizzo;
    private String nome;
    private String citta;

    public Edificio(String indirizzo, String nome, String citta) {
        this.indirizzo = indirizzo;
        this.nome = nome;
        this.citta = citta;
    }
}
