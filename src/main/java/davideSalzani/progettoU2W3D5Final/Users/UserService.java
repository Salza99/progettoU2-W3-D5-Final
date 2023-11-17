package davideSalzani.progettoU2W3D5Final.Users;

import davideSalzani.progettoU2W3D5Final.exceptions.AlreadyExistException;
import davideSalzani.progettoU2W3D5Final.security.securityDTO.NewOrganizzatoreDTO;
import davideSalzani.progettoU2W3D5Final.security.securityDTO.NewUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder bcrypt;
    public User save(NewUserDTO body) throws IOException {
        User u = new User();
        if (userRepo.findByUsername(body.username()).isPresent()) {
            throw new AlreadyExistException(body.username());
        } else if (userRepo.findByEmail(body.email()).isPresent()) {
            throw new AlreadyExistException(body.email());
        }else {
            u.setEmail(body.email());
            u.setUsername(body.username());
            u.setPassword(bcrypt.encode(body.password()));
            u.setRuolo(Role.UTENTE);
            userRepo.save(u);
            return u;
        }
    }
    public User save(NewOrganizzatoreDTO body) throws IOException {
        User u = new User();
        if (userRepo.findByUsername(body.username()).isPresent()) {
            throw new AlreadyExistException(body.username());
        } else if (userRepo.findByEmail(body.email()).isPresent()) {
            throw new AlreadyExistException(body.email());
        }else {
            u.setEmail(body.email());
            u.setUsername(body.username());
            u.setPassword(bcrypt.encode(body.password()));
            u.setRuolo(Role.ORGANIZZATORE);
            userRepo.save(u);
            return u;
        }
    }

}
