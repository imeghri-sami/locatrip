package fr.n7.services.impl;

import fr.n7.entities.PropertyImages;
import fr.n7.services.PropertyImageServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Stateless
public class PropertyImageServiceLocalImpl implements PropertyImageServiceLocal {

    @PersistenceContext(name="MaPU")
    private EntityManager em;

    @Override
    public Optional<PropertyImages> findOne(UUID id) {
        PropertyImages propertyImages = em.find(PropertyImages.class, id);
        return propertyImages == null ? Optional.empty() : Optional.of(propertyImages);
    }

    @Override
    public List<PropertyImages> findAll() {
        throw new UnsupportedOperationException("PropertyImageServiceLocalImpl::findAll is not implemented");
    }

    @Override
    public void save(PropertyImages o) {
        em.persist(o);
    }

    @Override
    public void delete(UUID id) {
        PropertyImages propertyImages = findOne(id).orElseThrow(NotFoundException::new);
        em.remove(propertyImages);
    }
}
