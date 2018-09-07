package kg.edu.iaau.beeline.util;

import kg.edu.iaau.beeline.other.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ResponseUtil
{
    @Autowired
    private MessageSource messageSource;

    public  ResponseEntity responseBuilder(String status, String messageKey,
                                                 Object data, HttpStatus httpStatus)
    {
        return new ResponseEntity(
                new CustomResponse(status, messageSource.getMessage( messageKey, new Object[0],
                        new Locale("")), data), httpStatus);
    }

    public  ResponseEntity responseBuilder(String status, String messageKey, HttpStatus httpStatus)
    {
        return new ResponseEntity(
                new CustomResponse(status, messageSource.getMessage( messageKey, new Object[0],
                        new Locale(""))), httpStatus);
    }
}