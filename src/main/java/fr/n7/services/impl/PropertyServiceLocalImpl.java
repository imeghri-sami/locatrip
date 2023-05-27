package fr.n7.services.impl;

import fr.n7.entities.Property;
import fr.n7.services.PropertyServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Stateless
public class PropertyServiceLocalImpl implements PropertyServiceLocal {

    @PersistenceContext(name = "MaPU") private EntityManager em;

    @Override
    public Optional<Property> findOne(Integer id) {
        return Optional.of(em.find(Property.class, id));
    }

    @Override
    public List<Property> findAll() {
        return em.createQuery("FROM Property p", Property.class)
                 .getResultList();
    }

    @Override
    public void save(Property o) {
        em.persist(o);
    }

    @Override
    public void delete(Integer id) {
        Property property = findOne(id).orElseThrow(NotFoundException::new);
        em.remove(property);
    }

    @Override
    public List<Property> findByType(String type) {
        TypedQuery<Property> query = em.createQuery(
                "FROM Property p WHERE p.type.name = :type", Property.class
        );


        query.setParameter("type", type);

        return query.getResultList();

    }
}
