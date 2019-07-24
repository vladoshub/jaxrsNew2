package ru.mmtr.jaxrs.daoimpl;

import ru.mmtr.jaxrs.api.HumanDao;
import ru.mmtr.jaxrs.model.Human;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

@ApplicationScoped
public class HumanDaoImpl implements HumanDao {

    @PersistenceContext(unitName = "Human")
    private EntityManager em;
    public List<Human> getHumans() {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Human> query = builder.createQuery(Human.class);
            Root<Human> root = query.from(Human.class);
            query.select(root);
            return em.createQuery(query).getResultList();
        } catch (Exception e) {
          return null;
        }
    }


    public void addHuman(Human human){
            try {
                em.merge(human);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}