package top.wisely.tenancy.dto;

import lombok.Value;
import top.wisely.tenancy.entity.Person;

@Value
public class PersonDto {
    private String name;
    private Integer age;
    public Person createPerson(){
        Person person = new Person();
        person.setName(this.name);
        person.setAge(this.age);
        return person;
    }
}
