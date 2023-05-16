package fr.n7.services;

import java.util.List;

public interface IDAO<T, E> {

    T findOne(E id);

    List<T> findAll();

}
