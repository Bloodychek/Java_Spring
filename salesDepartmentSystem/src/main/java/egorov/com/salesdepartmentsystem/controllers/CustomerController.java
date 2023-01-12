package egorov.com.salesdepartmentsystem.controllers;

import egorov.com.salesdepartmentsystem.models.Customer;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/customers/index")
    public String getAllRecords(Model model){
        model.addAttribute("customers", customerService.findAll());
        return findPaginated(1, model);
    }

    @GetMapping("/customers/create")
    public String createNewRecord(Model model){
        Customer customer = new Customer();
        model.addAttribute("customers", customer);
        return "customers/create";
    }

    @GetMapping("/customers/edit/{id}")
    public String editRecord(@PathVariable(value ="id") int id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customers", customer);
        return "customers/edit";
    }

    @PostMapping("/customers/save")
    public String saveRecord(@ModelAttribute("customers") Customer customer){
        customerService.save(customer);
        return "redirect:/customers/index";
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id){
        this.customerService.deleteById(id);
        return "redirect:/customers/index";
    }

    @GetMapping("/customers/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Customer> page = customerService.findPaginated(pageNo, pageSize);
        List<Customer> customers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("customers", customers);
        return "customers/index";
    }
}
