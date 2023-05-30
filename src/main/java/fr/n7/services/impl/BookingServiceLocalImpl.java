package fr.n7.services.impl;

import fr.n7.entities.Booking;
import fr.n7.services.BookingServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Stateless
public class BookingServiceLocalImpl implements BookingServiceLocal {
    @PersistenceContext(name = "MaPU")
    private EntityManager em;

    @Override
    public Optional<Booking> findOne(Integer id) {
        Booking booking = em.find(Booking.class, id);
        return booking == null ? Optional.empty() : Optional.of(booking);
    }

    @Override
    public List<Booking> findAll() {
        return em.createQuery("FROM Booking b").getResultList();
    }

    @Override
    public void delete(Integer id) {
        Booking booking = findOne(id).orElseThrow(NotFoundException::new);
        em.remove(booking);
    }

    @Override
    public void save(Booking o) {
        em.persist(o);
    }

    @Override
    public List<Booking> findByUeserId(int userId) {
        TypedQuery query = em.createQuery("FROM Booking b WHERE b.user.id = :user_id", Booking.class);
        query.setParameter("user_id", userId);
        return query.getResultList();
    }
}

