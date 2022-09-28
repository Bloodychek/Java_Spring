package egorov.com.salesdepartmentsystem.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 30, message = "The field 'username' should be between 3 and 30 characters")
    @NotEmpty
    @Column(name = "username")
    private String username;

    @Size(min = 3, max = 30, message = "The field 'password' should be between 3 and 30 characters")
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Transient
    @Size(message = "The field 'confirmPassword' should be the same as the field 'password'")
    @NotEmpty
    @Column(name = "confirmPassword")
    private String confirmPassword;

    @Email
    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Column(name = "mobilePhone")
    private String mobilePhone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Role roles;

    public User(String username, String password, String confirmPassword, String email, String mobilePhone, Role roles) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
