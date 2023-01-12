package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.Application;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.repositories.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ApplicationService {

    List<Application> findAll();

    void save(Application application);

    void deleteById(int id);

    Application getApplicationById(int id);

    Page<Application> findPaginated(int pageNo, int pageSize);
}
