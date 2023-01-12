package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.Transport;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.repositories.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransportService {
    List<Transport> findAll();

    void save(Transport transport);

    void deleteById(int id);

    Transport getTransportById(int id);

    Page<Transport> findPaginated(int pageNo, int pageSize);
}
