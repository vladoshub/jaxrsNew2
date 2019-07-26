package ru.mmtr.jaxrs.api;

import ru.mmtr.jaxrs.model.Human;
import ru.mmtr.jaxrs.searchcriteria.SearchCriteria;

import javax.persistence.criteria.Predicate;
import java.util.List;


public interface HumanDao {

    public List<Human> getHumans();
    public List<Human> getHumansByParams(SearchCriteria criteriaSearch);
    public void addHuman(Human human);
    public List<Human> getPredicate(SearchCriteria criteriaSearch);

}
