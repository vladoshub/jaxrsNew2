package ru.mmtr.jaxrs.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class HumanDto implements Serializable {

    private String name;
    private Long age;
    private Long growth;
    private Long id;

    public HumanDto(){
    }
    public HumanDto(String name, Long age, Long growth, Long id){
        this.name=name;
        this.age=age;
        this.growth=growth;
        this.id=id;
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

}
