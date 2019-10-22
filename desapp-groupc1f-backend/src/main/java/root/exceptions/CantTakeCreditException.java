package root.exceptions;

@SuppressWarnings("serial")
public class CantTakeCreditException extends Exception {
    public CantTakeCreditException(String msg){
        super(msg);
    }
}
