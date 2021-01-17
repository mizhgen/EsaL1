package beans;

import entities.Event;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class EventBean {

    @PersistenceContext(unitName = "esa")
    private EntityManager em;

    public Event add(Event entity) {
        return em.merge(entity);
    }

    public List<Event> findAll() {
        return em.createQuery("SELECT c FROM Event c", Event.class).getResultList();
    }
}