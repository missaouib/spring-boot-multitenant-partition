package top.wisely.tenancy.dto;

import top.wisely.tenancy.entity.Person;

public record PersonDto(String name, Integer age, String email) {
    public Person createPerson() {
        Person person = new Person();
        person.setName(this.name);
        person.setAge(this.age);
        person.setEmail(this.email);
        return person;
    }
}
