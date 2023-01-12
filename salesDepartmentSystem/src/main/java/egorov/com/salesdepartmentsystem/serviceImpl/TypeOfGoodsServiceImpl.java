package egorov.com.salesdepartmentsystem.serviceImpl;

import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.repositories.TypeOfGoodsRepository;
import egorov.com.salesdepartmentsystem.services.TypeOfGoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeOfGoodsServiceImpl implements TypeOfGoodsService {

    private final TypeOfGoodsRepository typeOfGoodsRepository;

    @Override
    public List<TypeOfGoods> findAll(){
        return typeOfGoodsRepository.findAll();
    }

    @Override
    public TypeOfGoods getTypeOfGoodsById(int id){
        Optional<TypeOfGoods> optional = typeOfGoodsRepository.findById(id);
        TypeOfGoods typeOfGoods = null;
        if(optional.isPresent()){
            typeOfGoods = optional.get();
        }
        else {
            throw new RuntimeException("Type of goods not found for id ::" + id);
        }
        return typeOfGoods;
    }

    @Override
    public void save(TypeOfGoods typeOfGoods){
        this.typeOfGoodsRepository.save(typeOfGoods);
    }

    @Override
    public void deleteById(int id){
        this.typeOfGoodsRepository.deleteById(id);
    }

    @Override
    public Page<TypeOfGoods> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.typeOfGoodsRepository.findAll(pageable);
    }
}
