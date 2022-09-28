package egorov.com.salesdepartmentsystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String customerName;
    @NotEmpty
    private String customerPhone;
    @NotEmpty
    private String customerFeedback;

    public Customer(String customerName, String customerPhone, String customerFeedback) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerFeedback = customerFeedback;
    }
}
