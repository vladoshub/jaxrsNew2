package ru.mmtr.jaxrs.searchcriteria;

public class SearchCriteria {
    private String name;
    private Long age;
    private Long growth;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrowth(Long growth) {
        this.growth = growth;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public Long getGrowth() {
        return growth;
    }

      public SearchCriteria(String name,Long age,Long growth){
        if(name!=null)
        this.name=name;
          if(age!=null)
        this.age=age;
          if(growth!=null)
        this.growth=growth;
      }
      public boolean isNull(){
            return name==null&&age==null&&growth==null;
      }
}
