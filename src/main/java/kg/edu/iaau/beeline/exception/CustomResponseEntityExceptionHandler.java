package kg.edu.iaau.beeline.exception;

import kg.edu.iaau.beeline.other.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;


@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomResponse> handleAllExceptions(Exception ex)
    {
        CustomResponse customResponse = new CustomResponse("ERROR", ex.getLocalizedMessage());
        return new ResponseEntity<>(customResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<CustomResponse> handleUsernameNotFoundException()
    {
        CustomResponse customResponse = new CustomResponse("ERROR",
                messageSource.getMessage("userNotFound",new Object[0], new Locale("")));

        return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
    }
}
