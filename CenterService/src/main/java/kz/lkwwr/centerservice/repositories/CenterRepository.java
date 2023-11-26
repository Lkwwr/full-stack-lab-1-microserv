package kz.lkwwr.centerservice.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.centerservice.entities.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CenterRepository extends JpaRepository<Center, Long> {
}
