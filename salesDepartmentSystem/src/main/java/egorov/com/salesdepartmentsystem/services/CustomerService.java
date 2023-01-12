package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.Customer;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer getCustomerById(int id);

    void save(Customer customer);

    void deleteById(int id);

    Page<Customer> findPaginated(int pageNo, int pageSize);
}
