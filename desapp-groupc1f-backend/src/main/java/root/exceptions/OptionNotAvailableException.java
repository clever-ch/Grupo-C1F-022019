package root.exceptions;

@SuppressWarnings("serial")
public class OptionNotAvailableException extends Exception {
    public OptionNotAvailableException(String msg){
        super(msg);
    }
}