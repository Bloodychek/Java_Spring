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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String tractor;
    @NotEmpty
    private String tractorBrand;
    @NotEmpty
    private String semitrailer;
    @NotEmpty
    private String semi_trailerBrand;
    @NotEmpty
    private String driverFIO;

    public Transport(String tractor, String tractorBrand, String semitrailer, String semi_trailerBrand, String driverFIO) {
        this.tractor = tractor;
        this.tractorBrand = tractorBrand;
        this.semitrailer = semitrailer;
        this.semi_trailerBrand = semi_trailerBrand;
        this.driverFIO = driverFIO;
    }
}
