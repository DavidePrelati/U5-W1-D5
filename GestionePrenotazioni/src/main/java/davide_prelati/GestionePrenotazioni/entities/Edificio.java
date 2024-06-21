package davide_prelati.GestionePrenotazioni.entities;


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
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String indirizzo;
    private String nome;
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

    public Edificio(String indirizzo, String nome, String citta, List<Postazione> postazioni) {
        this.indirizzo = indirizzo;
        this.nome = nome;
        this.citta = citta;
        this.postazioni = postazioni;
    }

}
