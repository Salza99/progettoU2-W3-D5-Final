package davideSalzani.progettoU2W3D5Final.events;

import davideSalzani.progettoU2W3D5Final.Users.User;
import davideSalzani.progettoU2W3D5Final.Users.UserRepository;
import davideSalzani.progettoU2W3D5Final.events.eventiDTO.NewEventDTO;
import davideSalzani.progettoU2W3D5Final.exceptions.EventCompleteException;
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
    public Event addPartecipazione(long userId, long eventId){
       User userFound = userRepo.findById(userId).orElseThrow(()-> new NotFoundException("user "));
       Event eventFound = eventRepo.findById(eventId).orElseThrow(()-> new NotFoundException("evento "));
        if (eventFound.getDisponibilita() == Disponibilita.COMPLETO) {
            throw new EventCompleteException();
        }else{
            eventFound.getPartecipanti().add(userFound);
            userFound.getPrenotazioni().add(eventFound);
            userRepo.save(userFound);
            eventRepo.save(eventFound);
            if (eventFound.getPartecipanti().size() == eventFound.getNumeroMassimoPartecipanti()){
                eventFound.setDisponibilita(Disponibilita.COMPLETO);
            }
        }return eventFound;

    }
}
