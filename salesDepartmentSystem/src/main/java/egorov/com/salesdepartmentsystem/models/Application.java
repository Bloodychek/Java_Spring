package egorov.com.salesdepartmentsystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss")
    @Column(name = "uploadDate")
    private LocalDateTime uploadDate;
    @NotEmpty
    @DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss")
    @Column(name = "unloadingDate")
    private LocalDateTime unloadingDate;
    @NotEmpty
    @Column(name = "paymentDayTime")
    private int paymentDayTime;
    @NotEmpty
    @Column(name = "currency")
    private String currency;
    @NotEmpty
    @Column(name = "applicationsNumber")
    private int applicationsNumber;
    @ManyToOne(targetEntity = Route.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "routeId")
    private Route routeId;
    @ManyToOne(targetEntity = Transport.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "transportId")
    private Transport transportId;
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customerId;
    @ManyToOne(targetEntity = OrderExecutor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderExecutorId")
    private OrderExecutor orderExecutorId;

    public Application(LocalDateTime uploadDate, LocalDateTime unloadingDate, int paymentDayTime, String currency, int applicationsNumber, Route routeId, Transport transportId, Customer customerId, OrderExecutor orderExecutorId) {
        this.uploadDate = uploadDate;
        this.unloadingDate = unloadingDate;
        this.paymentDayTime = paymentDayTime;
        this.currency = currency;
        this.applicationsNumber = applicationsNumber;
        this.routeId = routeId;
        this.transportId = transportId;
        this.customerId = customerId;
        this.orderExecutorId = orderExecutorId;
    }
}
