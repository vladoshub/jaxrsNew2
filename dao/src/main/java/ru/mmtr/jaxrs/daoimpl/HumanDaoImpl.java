package ru.mmtr.jaxrs.daoimpl;

import ru.mmtr.jaxrs.api.HumanDao;
import ru.mmtr.jaxrs.model.Human;
import ru.mmtr.jaxrs.searchcriteria.SearchCriteria;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
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
                if(human.getId()==null) {
                    em.persist(human);
                }
                else {
                    em.merge(human);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Override
    public List<Human> getHumansByParams(SearchCriteria searchCriteria) {
        try {
            return getPredicate(searchCriteria);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Human> getPredicate(SearchCriteria searchCriteria) {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Human> query = builder.createQuery(Human.class);
        Root<Human> root = query.from(Human.class);
        if(searchCriteria.getName()!=null) {
            Predicate predicateForName = builder.like(root.<String>get("name"), searchCriteria.getName().substring(0, 1) + "%");
            predicateList.add(predicateForName);
        }
        if(searchCriteria.getAge()!=null) {
            Predicate predicateForAge =builder.equal(root.<Long>get("age"),searchCriteria.getAge());
            predicateList.add(predicateForAge);
        }
        if(searchCriteria.getGrowth()!=null) {
            Predicate predicateForGrowth = builder.equal(root.<Long>get("growth"),searchCriteria.getGrowth());
            predicateList.add(predicateForGrowth);
        }
      Predicate[] predicates = new Predicate[predicateList.size()];
        int countPred=0;
        for (Predicate predicate : predicateList) {
            predicates[countPred]=predicate;
            countPred++;
        }

        Predicate finalPredicate = builder.and(predicates);
        query.select(root).where(finalPredicate);
         return em.createQuery(query).getResultList();
    }
}