package egorov.com.salesdepartmentsystem.repositories;

import egorov.com.salesdepartmentsystem.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository  extends JpaRepository<Goods, Long> {
}
