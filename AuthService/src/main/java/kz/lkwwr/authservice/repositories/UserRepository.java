package kz.lkwwr.authservice.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.authservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
}
