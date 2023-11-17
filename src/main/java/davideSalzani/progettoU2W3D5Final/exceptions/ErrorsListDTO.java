package davideSalzani.progettoU2W3D5Final.exceptions;

import java.time.LocalDate;
import java.util.List;

public record ErrorsListDTO(
        String message,
        LocalDate timestamp,
        List<String> messageList
) {
}
