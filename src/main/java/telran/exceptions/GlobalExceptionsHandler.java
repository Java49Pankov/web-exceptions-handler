package telran.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionsHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<String> handlerMethodArgument(MethodArgumentNotValidException e) {
		String message = e.getFieldError().getDefaultMessage();
		log.error("method handlerMethodArgument, exception {}", message);
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ IllegalStateException.class })
	ResponseEntity<String> badRequest(IllegalStateException e) {
		String message = e.getMessage();
		log.error("method badRequest, exception {}", message);
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ NotFoundException.class })
	ResponseEntity<String> notFound(NotFoundException e) {
		String message = e.getMessage();
		log.error("method notFound, exception {}", message);
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}
}
