package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.Route;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RouteService {
    List<Route> findAll();

    void save(Route route);

    void deleteById(int id);

    Route getRouteById(int id);

    Page<Route> findPaginated(int pageNo, int pageSize);
}
