package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.User;
import egorov.com.salesdepartmentsystem.repositories.RoleRepository;
import egorov.com.salesdepartmentsystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserDetails checkUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Such mail was not found");
        }
        return user;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

}
