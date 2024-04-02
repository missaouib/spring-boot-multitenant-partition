package top.wisely.tenancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wisely.tenancy.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByName(String name);
}
