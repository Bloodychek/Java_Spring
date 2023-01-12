package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeOfGoodsRepository extends JpaRepository<TypeOfGoods, Integer> {
}
