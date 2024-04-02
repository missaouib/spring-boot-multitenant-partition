package top.wisely.tenancy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.wisely.tenancy.entity.Dealership;

@Repository
public interface AccountRepository extends JpaRepository<Dealership, Long> {
}