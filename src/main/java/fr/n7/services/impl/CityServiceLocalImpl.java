package fr.n7.services.impl;

import fr.n7.entities.City;
import fr.n7.services.CityServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Stateless
public class CityServiceLocalImpl implements CityServiceLocal {
    @PersistenceContext(name = "MaPU")
    private EntityManager em;

    @Override
    public Optional<City> findOne(Integer id) {
        City city = em.find(City.class, id);
        return city == null ? Optional.empty() : Optional.of(city);
    }

    @Override
    public List<City> findAll() {
        return em.createQuery("FROM City c").getResultList();
    }

    @Override
    public void delete(Integer id) {
        City city = findOne(id).orElseThrow(NotFoundException::new);
        em.remove(city);
    }

    @Override
    public void save(City city) {
        em.persist(city);
    }
}

