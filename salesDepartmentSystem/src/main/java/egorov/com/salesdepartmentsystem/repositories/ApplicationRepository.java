package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
