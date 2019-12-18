package root.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserInvalidException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(UserInvalidException.class);
	
	public UserInvalidException(String message){
		LOG.error(message);
     }
}
