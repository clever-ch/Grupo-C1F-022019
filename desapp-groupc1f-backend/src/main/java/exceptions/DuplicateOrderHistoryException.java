package exceptions;

@SuppressWarnings("serial")
public class DuplicateOrderHistoryException extends Exception {
	public DuplicateOrderHistoryException(String msj) {
		super(msj);
	}
}
