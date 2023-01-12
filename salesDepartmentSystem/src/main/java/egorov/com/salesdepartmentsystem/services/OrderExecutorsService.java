package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.OrderExecutor;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.repositories.OrderExecutorsRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderExecutorsService {
    List<OrderExecutor> findAll();

    void save(OrderExecutor orderExecutor);

    void deleteById(int id);

    OrderExecutor getOrderExecutorById(int id);

    Page<OrderExecutor> findPaginated(int pageNo, int pageSize);
}
