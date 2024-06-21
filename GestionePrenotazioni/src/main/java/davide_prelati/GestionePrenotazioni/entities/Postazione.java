package davide_prelati.GestionePrenotazioni.entities;

import davide_prelati.GestionePrenotazioni.enums.Tipo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, Tipo tipo, Edificio edificio, List<Prenotazione> prenotazioni) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.edificio = edificio;
        this.prenotazioni = prenotazioni;
    }

}
