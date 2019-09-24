package exceptions;

@SuppressWarnings("serial")
public class DuplicateOrderException extends Exception{
	public DuplicateOrderException(String msj) {
		super(msj);
	}
}
