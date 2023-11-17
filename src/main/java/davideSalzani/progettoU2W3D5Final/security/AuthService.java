package davideSalzani.progettoU2W3D5Final.security;

import davideSalzani.progettoU2W3D5Final.Users.User;
import davideSalzani.progettoU2W3D5Final.Users.UserRepository;
import davideSalzani.progettoU2W3D5Final.exceptions.NotFoundException;
import davideSalzani.progettoU2W3D5Final.exceptions.UnauthorizedException;
import davideSalzani.progettoU2W3D5Final.security.securityDTO.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository usersRepo;
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private JWTTools jwtTools;
    public String authenticateUser(UserLoginDTO body){
        User user = usersRepo.findByEmail(body.email()).orElseThrow(()-> new NotFoundException("User"));
        if(bcrypt.matches(body.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Credenziali non valide!");
        }
    }
}
