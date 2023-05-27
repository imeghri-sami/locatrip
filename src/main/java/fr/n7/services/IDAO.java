package fr.n7.services;

import fr.n7.entities.User;

import java.util.List;
import java.util.Optional;

public interface IDAO<T, E> {

    Optional<T> findOne(E id);

    List<T> findAll();

    void save(T o);

    void delete(E id);
}
