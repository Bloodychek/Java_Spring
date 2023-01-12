package egorov.com.salesdepartmentsystem.serviceImpl;

import egorov.com.salesdepartmentsystem.models.Route;
import egorov.com.salesdepartmentsystem.repositories.RouteRepository;
import egorov.com.salesdepartmentsystem.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    public List<Route> findAll(){
        return routeRepository.findAll();
    }

    @Override
    public void save(Route route) {
        this.routeRepository.saveAndFlush(route);
    }

    @Override
    public void deleteById(int id) {
        this.routeRepository.deleteById(id);
    }

    @Override
    public Route getRouteById(int id) {
        Optional<Route> optional = routeRepository.findById(id);
        Route route;
        if(optional.isPresent()){
            route = optional.get();
        } else {
            throw new RuntimeException("Route not found for id ::" + id);
        }
        return route;
    }

    @Override
    public Page<Route> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.routeRepository.findAll(pageable);
    }
}
