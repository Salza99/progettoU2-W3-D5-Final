package davideSalzani.progettoU2W3D5Final.security.securityDTO;

import jakarta.validation.constraints.NotEmpty;

public record UserLoginDTO(
        @NotEmpty(message = "il campo email non può essere lasciato vuoto")
        String email,
        @NotEmpty(message = "il campo password non può essere lasciato vuoto")
        String password
) {
}
