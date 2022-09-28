package egorov.com.salesdepartmentsystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(targetEntity = Application.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private int applicationId;
    @OneToOne(targetEntity = TypeOfGoods.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private int typeOfGoodsId;
    @NotEmpty
    private int countOfGoods;
    @NotEmpty
    private String productPrice;

    public Goods(int applicationId, int typeOfGoodsId, int countOfGoods, String productPrice) {
        this.applicationId = applicationId;
        this.typeOfGoodsId = typeOfGoodsId;
        this.countOfGoods = countOfGoods;
        this.productPrice = productPrice;
    }
}
