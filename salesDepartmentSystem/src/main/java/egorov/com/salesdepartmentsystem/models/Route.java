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
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "departurePoint")
    private String departurePoint;
    @NotEmpty
    @Column(name = "arrivalPoint")
    private String arrivalPoint;
    @NotEmpty
    @Column(name = "stoppingPoint")
    private String stoppingPoint;

    public Route(String departurePoint, String arrivalPoint, String stoppingPoint) {
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.stoppingPoint = stoppingPoint;
    }
}
