package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
