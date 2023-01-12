package egorov.com.salesdepartmentsystem.serviceImpl;

import egorov.com.salesdepartmentsystem.models.Goods;
import egorov.com.salesdepartmentsystem.repositories.GoodsRepository;
import egorov.com.salesdepartmentsystem.services.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;

    public List<Goods> findAll(){
        return goodsRepository.findAll();
    }

    @Override
    public void save(Goods goods) {
        goodsRepository.save(goods);
    }

    @Override
    public Goods getGoodsById(int id) {
        Optional<Goods> optional = goodsRepository.findById(id);
        Goods goods;
        if(optional.isPresent()){
            goods = optional.get();
        } else {
            throw new RuntimeException("Goods not found for id ::" + id);
        }
        return goods;
    }

    @Override
    public void deleteById(int id) {
        this.goodsRepository.deleteById(id);
    }

    @Override
    public Page<Goods> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.goodsRepository.findAll(pageable);
    }
}
