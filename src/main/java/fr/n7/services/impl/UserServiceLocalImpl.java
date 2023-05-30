package fr.n7.services.impl;

import fr.n7.entities.User;
import fr.n7.services.UserServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.NotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserServiceLocalImpl implements UserServiceLocal {
    @PersistenceContext(name="MaPU")
    private EntityManager em;

    @Override
    public Optional<User> findOne(Integer id) {
        return Optional.of(em.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User o) {
        o.setCreated(new Date());
        em.persist(o);
    }

    @Override
    public void delete(Integer id) {
        User user = findOne(id).orElseThrow(NotFoundException::new);
        em.remove(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = em.createQuery("FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);

        try {
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public boolean isEmailExists (String email){
        return findByEmail(email).orElse(null) != null;
    }
}
