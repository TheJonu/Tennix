package bada.service;

import bada.dao.UserRepository;
import bada.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found", username)));
        return user;
    }

    public Iterable<User> getAll(){
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    public User getById(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with ID %s not found", id)));
        return user;
    }

    public User getByUsername(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found", username)));
        return user;
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}