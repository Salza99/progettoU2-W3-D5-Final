package davideSalzani.progettoU2W3D5Final.events;

import davideSalzani.progettoU2W3D5Final.events.eventiDTO.NewEventDTO;
import davideSalzani.progettoU2W3D5Final.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventService eventService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public Event createEvent(@RequestBody @Validated NewEventDTO body, BindingResult validation){
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }else return eventService.save(body);
    }
    @PatchMapping("{userId}/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public Event addPartecipazione(@PathVariable("userId") long userId, @PathVariable("eventId") long eventId){
        return eventService.addPartecipazione(userId, eventId);
    }
    @PatchMapping("/upload/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public Event uploadImage(@RequestParam("cover") MultipartFile file, @PathVariable("id") long id) throws IOException {
        return eventService.UploadImage(file, id);
    }
}
