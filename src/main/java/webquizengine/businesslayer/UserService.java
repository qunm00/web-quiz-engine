package webquizengine.businesslayer;

import webquizengine.repository.UserRepository;
import webquizengine.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SecurityConfiguration securityConfiguration;


    public void save(User user) {
        if (this.userRepository.existsById(user.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "user already registered"
            );
        }
        user.setPassword(securityConfiguration.getEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public User get(String email) {
        Optional<User> user = this.userRepository.findById(email);
        user.orElseThrow(() -> new UsernameNotFoundException(email));
        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findById(email);
        user.orElseThrow(() -> new UsernameNotFoundException(email));
        return user.get();
    }
}