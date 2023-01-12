package egorov.com.salesdepartmentsystem.serviceImpl;

import egorov.com.salesdepartmentsystem.models.OrderExecutor;
import egorov.com.salesdepartmentsystem.repositories.OrderExecutorsRepository;
import egorov.com.salesdepartmentsystem.services.OrderExecutorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderExecutorsServiceImpl implements OrderExecutorsService {
    private final OrderExecutorsRepository orderExecutorsRepository;

    public List<OrderExecutor> findAll(){
        return orderExecutorsRepository.findAll();
    }

    @Override
    public void save(OrderExecutor orderExecutor) {
        this.orderExecutorsRepository.saveAndFlush(orderExecutor);
    }

    @Override
    public void deleteById(int id) {
        this.orderExecutorsRepository.deleteById(id);
    }

    @Override
    public OrderExecutor getOrderExecutorById(int id) {
        Optional<OrderExecutor> optional = orderExecutorsRepository.findById(id);
        OrderExecutor orderExecutor;
        if(optional.isPresent()){
            orderExecutor = optional.get();
        } else {
            throw new RuntimeException("Order executors not found for id ::" + id);
        }
        return orderExecutor;
    }

    @Override
    public Page<OrderExecutor> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.orderExecutorsRepository.findAll(pageable);
    }
}
