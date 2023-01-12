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
@Table(name = "typeofgoods")
public class TypeOfGoods {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "nameOfGoods")
    private String nameOfGoods;
    @NotEmpty
    @Column(name = "unit")
    private String unit;

    public TypeOfGoods(String nameOfGoods, String unit) {
        this.nameOfGoods = nameOfGoods;
        this.unit = unit;
    }
}
