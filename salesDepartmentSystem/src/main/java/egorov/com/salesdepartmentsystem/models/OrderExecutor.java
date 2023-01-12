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
@Table(name = "orderexecutors")
public class OrderExecutor {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "orderExecutorName")
    private String orderExecutorName;
    @NotEmpty
    @Column(name = "orderExecutorPhone")
    private String orderExecutorPhone;
    @NotEmpty
    @Column(name = "orderExecutorFeedback")
    private String orderExecutorFeedback;

    public OrderExecutor(String orderExecutorName, String orderExecutorPhone, String orderExecutorFeedback) {
        this.orderExecutorName = orderExecutorName;
        this.orderExecutorPhone = orderExecutorPhone;
        this.orderExecutorFeedback = orderExecutorFeedback;
    }
}
