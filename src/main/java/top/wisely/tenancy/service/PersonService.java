package top.wisely.tenancy.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wisely.tenancy.entity.Person;
import top.wisely.tenancy.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @PersistenceContext
    EntityManager entityManager;

    private final PersonRepository repository;

    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Person> findByName(String name){
        return repository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Person> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Person save(Person person){
        return repository.save(person);
    }

    public List<Person> findUnwrap(){
        Session session = entityManager.unwrap(Session.class);
        session.disableFilter("tenancy-filter");
        return session.createQuery("select p from Person p", Person.class).getResultList();
    }

}
