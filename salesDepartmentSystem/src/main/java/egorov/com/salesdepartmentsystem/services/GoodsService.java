package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.Goods;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.repositories.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {
    List<Goods> findAll();

    void save(Goods goods);

    Goods getGoodsById(int id);

    void deleteById(int id);

    Page<Goods> findPaginated(int pageNo, int pageSize);
}
