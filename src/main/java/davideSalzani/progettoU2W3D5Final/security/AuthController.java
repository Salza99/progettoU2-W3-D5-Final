package davideSalzani.progettoU2W3D5Final.security;

import davideSalzani.progettoU2W3D5Final.Users.User;
import davideSalzani.progettoU2W3D5Final.Users.UserService;
import davideSalzani.progettoU2W3D5Final.exceptions.BadRequestException;
import davideSalzani.progettoU2W3D5Final.security.securityDTO.NewUserDTO;
import davideSalzani.progettoU2W3D5Final.security.securityDTO.UserLoginDTO;
import davideSalzani.progettoU2W3D5Final.security.securityDTO.UserLoginSuccessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService usersService;
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public User saveUser(@RequestBody @Validated NewUserDTO body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return usersService.save(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @PostMapping("/login")
    public UserLoginSuccessDTO login(@RequestBody @Validated UserLoginDTO body, BindingResult validation){
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }
        return new UserLoginSuccessDTO(authService.authenticateUser(body));
    }
}
