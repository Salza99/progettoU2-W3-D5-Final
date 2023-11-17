package davideSalzani.progettoU2W3D5Final.security.securityDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "il campo username non può essere lasciato vuoto")
        @Size(min = 3, message = "l'username deve contenere almeno 3 caratteri")
        String username,
        @NotEmpty(message = "il campo email non può essere lasciato vuoto")
        @Email(regexp = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", message = "inserire una mail valida!")
        String email,
        @NotEmpty(message = "il campo password non può essere lasciato vuoto")
        @Pattern(regexp = "^(?=.*[0-9].*[0-9].*[0-9])(?=.*[A-Z])[A-Za-z0-9]{8,}$", message = "la password deve contenere almeno 3 numeri e una lettera maiuscola")
        String password

) {
}
