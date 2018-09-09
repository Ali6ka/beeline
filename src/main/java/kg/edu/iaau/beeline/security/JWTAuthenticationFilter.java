package kg.edu.iaau.beeline.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.edu.iaau.beeline.entity.Person;
import kg.edu.iaau.beeline.entity.dto.PersonDTO;
import kg.edu.iaau.beeline.other.CustomResponse;
import kg.edu.iaau.beeline.service.PersonService;
import kg.edu.iaau.beeline.transfer.View;
import kg.edu.iaau.beeline.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static kg.edu.iaau.beeline.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    @Autowired
    private PersonService personService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ResponseUtil responseUtil;

    public JWTAuthenticationFilter()
    {}

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager)
    {
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException
    {
        try {
            Person creds = new ObjectMapper()
                    .readValue(req.getInputStream(), Person.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse res,
                                              AuthenticationException authException) throws IOException, ServletException
    {
        res.setContentType("application/json");
        CustomResponse customResponse;

        if(authException instanceof UsernameNotFoundException) {
            res.setStatus(HttpStatus.NOT_FOUND.value());
            customResponse = responseUtil.
                    responseBuilder("ERROR", "userNotFound");

        } else if (authException instanceof BadCredentialsException) {
            res.setStatus(HttpStatus.FORBIDDEN.value());
            customResponse = responseUtil.
                    responseBuilder("ERROR", "incorrectPassword");
        } else {
            customResponse = new CustomResponse();
        }

        OutputStream out = res.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, customResponse);
        out.flush();
    }

    @Override
    @JsonView({View.Details.class})
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                            FilterChain chain, Authentication auth) throws IOException, ServletException
    {
        String username = ((User) auth.getPrincipal()).getUsername();

        String token = JWT.create()
                .withSubject((username))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));

        PersonDTO personDTO =  modelMapper.
                map(personService.findByUsername(username), PersonDTO.class);

        personDTO.setAuthToken(token);

        String personJson = mapper
                .writerWithView(View.AuthDetails.class)
                .writeValueAsString(personDTO);

        JsonNode jsonNode = mapper.readTree(personJson);

        CustomResponse  customResponse = responseUtil.
                responseBuilder("ERROR", "successLogin", jsonNode);


        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.setContentType("application/json");
        res.setStatus(HttpStatus.OK.value());

        OutputStream out = res.getOutputStream();
        mapper.writeValue(out, customResponse);
        out.flush();
    }
}