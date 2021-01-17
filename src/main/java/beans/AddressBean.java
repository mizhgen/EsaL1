package beans;

import entities.Address;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class AddressBean {

    @PersistenceContext(unitName = "esa")
    private EntityManager em;

    public Address add(Address entity) {
        return em.merge(entity);
    }
}