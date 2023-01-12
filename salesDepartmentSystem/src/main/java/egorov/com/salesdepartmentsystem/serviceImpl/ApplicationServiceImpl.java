package egorov.com.salesdepartmentsystem.serviceImpl;

import egorov.com.salesdepartmentsystem.models.Application;
import egorov.com.salesdepartmentsystem.repositories.ApplicationRepository;
import egorov.com.salesdepartmentsystem.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    public List<Application> findAll(){
        return applicationRepository.findAll();
    }

    @Override
    public void save(Application application) {
        this.applicationRepository.saveAndFlush(application);
    }

    @Override
    public void deleteById(int id) {
        this.applicationRepository.deleteById(id);
    }

    @Override
    public Application getApplicationById(int id) {
        Optional<Application> optional = applicationRepository.findById(id);
        Application application;
        if(optional.isPresent()){
            application = optional.get();
        } else {
            throw new RuntimeException("Application not found for id ::" + id);
        }
        return application;
    }

    @Override
    public Page<Application> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.applicationRepository.findAll(pageable);
    }
}
