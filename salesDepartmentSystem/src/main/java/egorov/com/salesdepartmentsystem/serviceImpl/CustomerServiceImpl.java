package egorov.com.salesdepartmentsystem.serviceImpl;

import egorov.com.salesdepartmentsystem.models.Customer;
import egorov.com.salesdepartmentsystem.repositories.CustomerRepository;
import egorov.com.salesdepartmentsystem.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        Optional <Customer> optional = customerRepository.findById(id);
        Customer customer;
        if(optional.isPresent()){
            customer = optional.get();
        } else {
            throw new RuntimeException("Customer not found for id ::" + id);
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteById(int id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.customerRepository.findAll(pageable);
    }
}
