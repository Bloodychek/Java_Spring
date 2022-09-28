package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
