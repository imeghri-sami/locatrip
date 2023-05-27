package fr.n7.services.impl;

import fr.n7.entities.Property;
import fr.n7.entities.PropertyImages;
import fr.n7.services.PropertyImageServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class PropertyImageServiceLocalImpl implements PropertyImageServiceLocal {

    @PersistenceContext(name="MaPU")
    private EntityManager em;

    @Override
    public Optional<PropertyImages> findOne(Integer id) {
        return Optional.of(em.find(PropertyImages.class, id));
    }

    @Override
    public List<PropertyImages> findAll() {
        throw new UnsupportedOperationException("PropertyImageServiceLocalImpl::findAll is not implemented");
    }

    @Override
    public void save(PropertyImages o) {
        throw new UnsupportedOperationException("PropertyImageServiceLocalImpl::save is not implemented");
    }

    @Override
    public void delete(Integer id) {

    }
}
