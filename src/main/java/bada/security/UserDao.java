package bada.security;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}