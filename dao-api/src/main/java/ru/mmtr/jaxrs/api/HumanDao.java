package ru.mmtr.jaxrs.api;

import ru.mmtr.jaxrs.model.Human;

import java.util.List;

public interface HumanDao {

    public List<Human> getHumans();
    public void addHuman(Human human);
}
