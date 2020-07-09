package ie.cct.farmmanagerca;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND) //need to return a Httpstatus not found
public class NotFoundException extends RuntimeException { //NotFoundException needs to inherit from RunTimeException
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// passing a message into the exception using constructor
	public NotFoundException(String msg) {
		super(msg); // it calls the constructor in the parent, which is RuntimeException, and pass the message on
	}

}
