package exceptions;

@SuppressWarnings("serial")
public class DuplicateFoodServiceException extends Exception {
	public DuplicateFoodServiceException(String msj){
		super(msj);
	}
}
