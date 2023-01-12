package egorov.com.salesdepartmentsystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Application.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "applicationId")
    private Application applicationId;
    @ManyToOne(targetEntity = TypeOfGoods.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "typeOfGoodsId")
    private TypeOfGoods typeOfGoodsId;
    @NotEmpty
    @Column(name = "countOfGoods")
    private int countOfGoods;
    @NotEmpty
    @Column(name = "productPrice")
    private String productPrice;

    public Goods(Application applicationId, TypeOfGoods typeOfGoodsId, int countOfGoods, String productPrice) {
        this.applicationId = applicationId;
        this.typeOfGoodsId = typeOfGoodsId;
        this.countOfGoods = countOfGoods;
        this.productPrice = productPrice;
    }
}
