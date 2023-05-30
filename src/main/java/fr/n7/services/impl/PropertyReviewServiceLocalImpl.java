package fr.n7.services.impl;

import fr.n7.entities.Property;
import fr.n7.entities.PropertyReview;
import fr.n7.services.PropertyReviewServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Stateless
public class PropertyReviewServiceLocalImpl implements PropertyReviewServiceLocal {

    @PersistenceContext(name ="MaPU")
    private EntityManager em;

    @Override
    public Optional<PropertyReview> findOne(Integer id) {
        PropertyReview propertyReview = em.find(PropertyReview.class, id);
        return propertyReview == null ? Optional.empty() : Optional.of(propertyReview);
    }

    @Override
    public List<PropertyReview> findAll() {
        throw new UnsupportedOperationException("PropertyReviewServiceLocalImpl::findAll is not implemented");
    }

    @Override
    public void save(PropertyReview o) {
        if (o != null) {
            em.persist(o);
        } else {
            throw new IllegalArgumentException("PropertyReview cannot be null.");
        }
    }

    @Override
    public void delete(Integer id) {
        PropertyReview propertyReview = findOne(id).orElseThrow(NotFoundException::new);
        em.remove(propertyReview);
    }

    @Override
    public List<PropertyReview> retrieveAllByPropertyId(int propertyId) {
        TypedQuery<PropertyReview> query = em
                .createQuery("FROM PropertyReview p WHERE p.property.id = :property_id", PropertyReview.class);
        query.setParameter("property_id", propertyId);
        return query.getResultList();
    }

    @Override
    public List<PropertyReview> retrieveAllByPropertyId(int propertyId, int page, int size) {
        throw new UnsupportedOperationException("PropertyReviewServiceLocalImpl::retrieveAllByPropertyId is not implemented");
    }

    @Override
    public void addReview(PropertyReview propertyReview) {

    }
}
