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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String orderExecutorName;
    @NotEmpty
    private String orderExecutorPhone;
    @NotEmpty
    private String orderExecutorFeedback;

    public OrderExecutor(String orderExecutorName, String orderExecutorPhone, String orderExecutorFeedback) {
        this.orderExecutorName = orderExecutorName;
        this.orderExecutorPhone = orderExecutorPhone;
        this.orderExecutorFeedback = orderExecutorFeedback;
    }
}
