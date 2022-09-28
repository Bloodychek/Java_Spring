package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
