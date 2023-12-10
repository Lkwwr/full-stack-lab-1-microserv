package kz.lkwwr.centerservice.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.centerservice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeesByCenter_Id(Long id);
}
