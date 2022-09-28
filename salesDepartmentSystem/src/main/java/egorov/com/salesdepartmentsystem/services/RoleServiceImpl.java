package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.Role;
import egorov.com.salesdepartmentsystem.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Long getAdminRoleId(){
        return roleRepository.findByName("ROLE_ADMIN").getId();
    }

    public Long getMainAccountantRoleId(){
        return roleRepository.findByName("ROLE_MAIN_ACCOUNTANT").getId();
    }

    public Long getAccountantRoleId(){
        return roleRepository.findByName("ROLE_ACCOUNTANT").getId();
    }
}
