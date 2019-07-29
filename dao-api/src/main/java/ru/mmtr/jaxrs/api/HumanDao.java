package ru.mmtr.jaxrs.api;

import ru.mmtr.jaxrs.model.Human;
import ru.mmtr.jaxrs.searchcriteria.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public interface HumanDao {

    public List<Human> getHumans();
    public List<Human> getHumansByParams(SearchCriteria criteriaSearch);
    public void addHuman(Human human);
    public Predicate getPredicate(SearchCriteria searchCriteria,CriteriaBuilder builder,CriteriaQuery query, Root<Human> root);
}
