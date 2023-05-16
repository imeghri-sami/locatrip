package fr.n7.services.impl;

import fr.n7.entities.Property;
import fr.n7.services.PropertyServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PropertyServiceLocalImpl implements PropertyServiceLocal {

    @PersistenceContext(name = "MaPU") private EntityManager em;

    @Override
    public Property findOne(Integer id) {
        throw new  UnsupportedOperationException("PropertyServiceLocalImpl::findOne not implemented");
    }

    @Override
    public List<Property> findAll() {
        return em.createQuery("FROM Property p", Property.class)
                 .getResultList();
    }
}
