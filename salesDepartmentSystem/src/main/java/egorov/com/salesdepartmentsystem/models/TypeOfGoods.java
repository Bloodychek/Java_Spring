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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nameOfGoods;
    @NotEmpty
    private String unit;

    public TypeOfGoods(String nameOfGoods, String unit) {
        this.nameOfGoods = nameOfGoods;
        this.unit = unit;
    }
}
