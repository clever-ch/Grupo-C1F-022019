package root.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ResourceNotFoundException.class);
	
	public ResourceNotFoundException(String message){
		LOG.error(message);
     }
}
