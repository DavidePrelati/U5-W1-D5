package davide_prelati.GestionePrenotazioni.entities;

import davide_prelati.GestionePrenotazioni.enums.Tipo;
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
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    private Tipo tipo;

    public Postazione(String descrizione, Tipo tipo) {
        this.descrizione = descrizione;
        this.tipo = tipo;
    }
}
