package fr.n7.services.impl;

import fr.n7.entities.PropertyReview;
import fr.n7.services.PropertyReviewServiceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class PropertyReviewServiceLocalImpl implements PropertyReviewServiceLocal {

    @PersistenceContext(name ="MaPU")
    private EntityManager em;

    @Override
    public Optional<PropertyReview> findOne(Integer id) {
        throw new UnsupportedOperationException("PropertyReviewServiceLocalImpl::findOne is not implemented");
    }

    @Override
    public List<PropertyReview> findAll() {
        throw new UnsupportedOperationException("PropertyReviewServiceLocalImpl::findAll is not implemented");
    }

    @Override
    public void save(PropertyReview o) {
        throw new UnsupportedOperationException("PropertyReviewServiceLocalImpl::save is not implemented");
    }

    @Override
    public void delete(Integer id) {

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
}
