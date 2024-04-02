package top.wisely.tenancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.wisely.tenancy.entity.Sale;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Long> {


}