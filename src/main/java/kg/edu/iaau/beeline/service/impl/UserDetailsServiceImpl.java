package kg.edu.iaau.beeline.service.impl;

import kg.edu.iaau.beeline.entity.Person;
import kg.edu.iaau.beeline.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Person person = personService.findByUsername(username);
        if (person == null)
        {
            throw new UsernameNotFoundException(username);
        }

        return new User(person.getUsername(), person.getPassword(), emptyList());
    }
}