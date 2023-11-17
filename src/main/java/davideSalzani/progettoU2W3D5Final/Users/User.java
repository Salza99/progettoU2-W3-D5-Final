package davideSalzani.progettoU2W3D5Final.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import davideSalzani.progettoU2W3D5Final.events.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role ruolo;
    @ManyToMany
    @JsonIgnore
    private List<Event> prenotazioni;
    @CreationTimestamp
    private LocalDate createdAt;

}
