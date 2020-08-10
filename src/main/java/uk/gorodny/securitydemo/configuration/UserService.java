package uk.gorodny.securitydemo.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // Можно брать пользователя откуда угодно. При необходимости замапить на uk.gorodny.securitydemo.configuration.User.java,
        // либо взять его из БД
        return null;
    }
}
