package davideSalzani.progettoU2W3D5Final.exceptions;

public class EventCompleteException extends RuntimeException{
    public EventCompleteException(){
        super("evento non più disponibile");
    }
}
