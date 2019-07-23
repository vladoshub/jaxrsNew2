package ru.mmtr.jaxrs.model;

public class Human {
    private String name;
    private int age;
    private int growth;
    private int id;

    public Human(){
    }
    public Human(String name,int age,int growth,int id){
        this.name=name;
        this.age=age;
        this.growth=growth;
        this.id=id;
    }

    public int getAge() {
        return age;
    }

    public int getGrowth() {
        return growth;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Human: "+name+" age:"+age+" growth:"+ growth;
    }


}