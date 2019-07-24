package ru.mmtr.jaxrs.model;

public class Human {

    private Long id;

    private String name;

    private Long age;

    private Long growth;

    public Human() {
    }

    public Human(String name, Long age, Long growth, Long id) {
        this.name = name;
        this.age = age;
        this.growth = growth;
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public Long getGrowth() {
        return growth;
    }

    public String getName() {
        return name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setGrowth(Long growth) {
        this.growth = growth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Human: " + name + " age:" + age + " growth:" + growth;
    }


}