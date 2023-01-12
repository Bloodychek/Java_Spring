package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
}
