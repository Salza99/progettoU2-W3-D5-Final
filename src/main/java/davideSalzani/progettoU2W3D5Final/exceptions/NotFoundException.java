package davideSalzani.progettoU2W3D5Final.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    public NotFoundException(String whichRecord){
        super(whichRecord + " non trovato a database!");
    }
}
