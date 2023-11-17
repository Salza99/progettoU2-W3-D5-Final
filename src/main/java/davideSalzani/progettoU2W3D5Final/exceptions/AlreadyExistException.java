package davideSalzani.progettoU2W3D5Final.exceptions;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String who){
        super(who + " già presente a database");
    }
}
