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
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(name = "customerName")
    private String customerName;
    @NotEmpty
    @Column(name = "customerPhone")
    private String customerPhone;
    @NotEmpty
    @Column(name = "customerFeedback")
    private String customerFeedback;

    public Customer(String customerName, String customerPhone, String customerFeedback) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerFeedback = customerFeedback;
    }
}
