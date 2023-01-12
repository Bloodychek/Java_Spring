package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
}
