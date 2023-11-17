package davideSalzani.progettoU2W3D5Final.exceptions;

import java.time.LocalDate;

public record ErrorsPayloadDTO(
        String message,
        LocalDate timeStamp
){
}
