package telran.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionsHandler {

	@ExceptionHandler({ IllegalStateException.class })
	ResponseEntity<String> badRequest(IllegalStateException e) {
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ NotFoundException.class })
	ResponseEntity<String> notFound(NotFoundException e) {
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}
}
