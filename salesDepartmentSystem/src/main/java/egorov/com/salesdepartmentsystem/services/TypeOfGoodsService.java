package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TypeOfGoodsService {
    List<TypeOfGoods> findAll();

    TypeOfGoods getTypeOfGoodsById(int id);

    void save(TypeOfGoods typeOfGoods);

    void deleteById(int id);

    Page<TypeOfGoods> findPaginated(int pageNo, int pageSize);
}
