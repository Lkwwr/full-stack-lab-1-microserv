package kz.lkwwr.authservice.repositories;

import javax.transaction.Transactional;
import kz.lkwwr.authservice.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
}
