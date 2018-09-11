package kg.edu.iaau.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.edu.iaau.api.other.CustomResponse;
import kg.edu.iaau.api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import static kg.edu.iaau.api.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter
{
    @Autowired
    private ResponseUtil responseUtil;

    @Autowired
    private ObjectMapper mapper;

    public JWTAuthorizationFilter(AuthenticationManager authManager)
    {
        super(authManager);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request)
    {
        String token = request.getHeader(HEADER_STRING);
        if (token != null)
        {
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null)
            {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException
    {
        String header = req.getHeader(HEADER_STRING);

        System.out.println(req.getRequestURL());
        if ((header == null || !header.startsWith(TOKEN_PREFIX)))
        {
            CustomResponse customResponse = responseUtil.
                    responseBuilder("ERROR", "notAuthorized");

            res.setContentType("application/json");
            res.setStatus(HttpStatus.UNAUTHORIZED.value());

            OutputStream out = res.getOutputStream();
            mapper.writeValue(out, customResponse);
            out.flush();
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

}