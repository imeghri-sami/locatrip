package fr.n7.services.impl;

import fr.n7.entities.Country;
import fr.n7.services.CountryServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Stateless
public class CountryServiceLocalImpl implements CountryServiceLocal {
    @PersistenceContext(name = "MaPU")
    private EntityManager em;

    @Override
    public Optional<Country> findOne(Integer id) {
        Country c = em.find(Country.class, id);
        return c == null ? Optional.empty() : Optional.of(c);
    }

    @Override
    public List<Country> findAll() {
        return em.createQuery("FROM Country c").getResultList();
    }

    @Override
    public void delete(Integer id) {
        Country c = findOne(id).orElseThrow(NotFoundException::new);
        em.remove(c);
    }

    @Override
    public void save(Country o) {
        em.persist(o);
    }
}
