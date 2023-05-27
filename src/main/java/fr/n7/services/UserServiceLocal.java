package fr.n7.services;

import fr.n7.entities.User;

import javax.ejb.Local;
import java.util.Optional;

@Local
public interface UserServiceLocal extends IDAO<User, Integer>{

    Optional<User> findByEmail(String email);
    boolean isEmailExists (String email);
}
