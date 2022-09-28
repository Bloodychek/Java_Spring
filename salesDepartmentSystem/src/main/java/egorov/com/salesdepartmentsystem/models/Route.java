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
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String departurePoint;
    @NotEmpty
    private String arrivalPoint;
    @NotEmpty
    private String stoppingPoint;

    public Route(String departurePoint, String arrivalPoint, String stoppingPoint) {
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.stoppingPoint = stoppingPoint;
    }
}
