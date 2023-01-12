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
@Table(name = "transports")
public class Transport {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "tractor")
    private String tractor;
    @NotEmpty
    @Column(name = "tractorBrand")
    private String tractorBrand;
    @NotEmpty
    @Column(name = "semitrailer")
    private String semitrailer;
    @NotEmpty
    @Column(name = "semi_trailerBrand")
    private String semi_trailerBrand;
    @NotEmpty
    @Column(name = "driverFIO")
    private String driverFIO;

    public Transport(String tractor, String tractorBrand, String semitrailer, String semi_trailerBrand, String driverFIO) {
        this.tractor = tractor;
        this.tractorBrand = tractorBrand;
        this.semitrailer = semitrailer;
        this.semi_trailerBrand = semi_trailerBrand;
        this.driverFIO = driverFIO;
    }
}
