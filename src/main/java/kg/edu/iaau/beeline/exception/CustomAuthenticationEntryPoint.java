package kg.edu.iaau.beeline.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.edu.iaau.beeline.other.CustomResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint
{
    @Autowired
    private MessageSource messageSource;

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException
    {
        res.setContentType("application/json");
        CustomResponse customResponse;

        if(authException.getClass().isAssignableFrom(UsernameNotFoundException.class)) {
            res.setStatus(HttpStatus.NOT_FOUND.value());
             customResponse = new CustomResponse("ERROR",
                    messageSource.getMessage("userNotFound",new Object[0], new Locale("")));

        } else {
            res.setStatus(HttpStatus.FORBIDDEN.value());

             customResponse = new CustomResponse("ERROR",
                    messageSource.getMessage("notAuthorized",new Object[0], new Locale("")));
        }

        OutputStream out = res.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, customResponse);
        out.flush();
    }
}
