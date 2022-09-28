package egorov.com.salesdepartmentsystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private Date uploadDate;
    @NotEmpty
    private Date unloadingDate;
    @NotEmpty
    @Range(min = 1)
    private int paymentDayTime;
    @NotEmpty
    private String currency;
    @NotEmpty
    private int applicationNumber;
    @OneToOne(targetEntity = Route.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private int routeId;
    @OneToOne(targetEntity = Transport.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private int transportId;
    @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private int customerId;
    @OneToOne(targetEntity = OrderExecutor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private int orderExecutorId;

    public Application(Date uploadDate, Date unloadingDate, int paymentDayTime, String currency, int applicationNumber, int routeId, int transportId, int customerId, int orderExecutorId) {
        this.uploadDate = uploadDate;
        this.unloadingDate = unloadingDate;
        this.paymentDayTime = paymentDayTime;
        this.currency = currency;
        this.applicationNumber = applicationNumber;
        this.routeId = routeId;
        this.transportId = transportId;
        this.customerId = customerId;
        this.orderExecutorId = orderExecutorId;
    }
}
