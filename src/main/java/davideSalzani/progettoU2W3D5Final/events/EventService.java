package davideSalzani.progettoU2W3D5Final.events;

import davideSalzani.progettoU2W3D5Final.Users.UserRepository;
import davideSalzani.progettoU2W3D5Final.events.eventiDTO.NewEventDTO;
import davideSalzani.progettoU2W3D5Final.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepo;
    @Autowired
    UserRepository userRepo;

    public Event save(NewEventDTO body){
        Event e = new Event();

        e.setTitolo(body.titolo());
        e.setDescrizione(body.descrizione());
        e.setLuogo(body.luogo());
        e.setData(body.data());
        e.setNumeroMassimoPartecipanti(body.numeroMassimo());
        e.setDisponibilita(Disponibilita.DISPONIBILE);

        eventRepo.save(e);
        return e;
    }
    
}
