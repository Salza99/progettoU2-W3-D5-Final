package davideSalzani.progettoU2W3D5Final.events.eventiDTO;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record NewEventDTO(
        @NotEmpty(message = "il campo titolo non può essere lasciato vuoto")
        String titolo,
        @NotEmpty(message = "il campo descrizione non può essere lasciato vuoto")
        String descrizione,
        @NotEmpty(message = "il campo luogo non può essere lasciato vuoto")
        String luogo,
        @NotNull(message = "La data non può essere nulla")
        @Future(message = "la data non è valida")
        LocalDate data,
        @NotNull(message = "il campo numero massimo non può essere lasciato vuoto")
        @Min(value = 10, message = "non puoi inserire eventi con un numero di persone inferiore a 10")
        @Max(value = 100, message = "non puoi inserire eventi con un numero di persone maggiore a 100")
        Integer numeroMassimo
) {
}
