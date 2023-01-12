package egorov.com.salesdepartmentsystem.serviceImpl;

import egorov.com.salesdepartmentsystem.models.Transport;
import egorov.com.salesdepartmentsystem.repositories.TransportRepository;
import egorov.com.salesdepartmentsystem.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl  implements TransportService {
    private final TransportRepository transportRepository;

    public List<Transport> findAll(){
        return transportRepository.findAll();
    }

    @Override
    public void save(Transport transport) {
        this.transportRepository.saveAndFlush(transport);
    }

    @Override
    public void deleteById(int id) {
        this.transportRepository.deleteById(id);
    }

    @Override
    public Transport getTransportById(int id) {
        Optional<Transport> optional = transportRepository.findById(id);
        Transport transport;
        if(optional.isPresent()){
            transport = optional.get();
        } else {
            throw new RuntimeException("Transport not found for id ::" + id);
        }
        return transport;
    }

    @Override
    public Page<Transport> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.transportRepository.findAll(pageable);
    }
}
