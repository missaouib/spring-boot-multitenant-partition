package top.wisely.tenancy.controller;

import org.springframework.web.bind.annotation.*;
import top.wisely.tenancy.dto.PersonDto;
import top.wisely.tenancy.entity.Person;
import top.wisely.tenancy.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public Person save(@RequestBody PersonDto personDto){
        return  personService.save(personDto.createPerson());
    }

    @GetMapping
    private List<Person> all(){
        return personService.findAll();
    }

    @GetMapping("/unwrap")
    private List<Person> findUnwrap(){
        return personService.findUnwrap();
    }
}
