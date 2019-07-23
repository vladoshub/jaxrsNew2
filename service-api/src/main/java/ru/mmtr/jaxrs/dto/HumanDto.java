package ru.mmtr.jaxrs.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class HumanDto implements Serializable {

    private String name;
    private int age;
    private int growth;
    private int id;

    public HumanDto(){
    }
    public HumanDto(String name,int age,int growth,int id){
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

}
