package davideSalzani.progettoU2W3D5Final.events;

import davideSalzani.progettoU2W3D5Final.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int numeroMassimoPartecipanti;
    @ManyToMany()
    private List<User> partecipanti= new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Disponibilita disponibilita;
}
