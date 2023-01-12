package egorov.com.salesdepartmentsystem.controllers;

import egorov.com.salesdepartmentsystem.models.Customer;
import egorov.com.salesdepartmentsystem.models.OrderExecutor;
import egorov.com.salesdepartmentsystem.services.OrderExecutorsService;
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
public class OrderExecutorController {
    private final OrderExecutorsService orderExecutorsService;

    @GetMapping("/orderexecutors/index")
    public String getAllRecords(Model model){
        model.addAttribute("orderExecutors", orderExecutorsService.findAll());
        return findPaginated(1, model);
    }

    @GetMapping("/orderexecutors/create")
    public String createNewRecord(Model model){
        OrderExecutor orderExecutor = new OrderExecutor();
        model.addAttribute("orderExecutors", orderExecutor);
        return "orderexecutors/create";
    }

    @GetMapping("orderexecutors/edit/{id}")
    public String editRecord(@PathVariable(value = "id") int id, Model model){
        OrderExecutor orderExecutor = orderExecutorsService.getOrderExecutorById(id);
        model.addAttribute("orderExecutors", orderExecutor);
        return "orderexecutors/edit";
    }

    @GetMapping("/orderexecutors/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id){
        this.orderExecutorsService.deleteById(id);
        return "redirect:/orderexecutors/index";
    }

    @PostMapping("/orderexecutors/save")
    public String saveRecord(@ModelAttribute("orderexecutors") OrderExecutor orderExecutor){
        orderExecutorsService.save(orderExecutor);
        return "redirect:/orderexecutors/index";
    }

    @GetMapping("/orderexecutors/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<OrderExecutor> page = orderExecutorsService.findPaginated(pageNo, pageSize);
        List<OrderExecutor> orderExecutors = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("orderExecutors", orderExecutors);
        return "orderexecutors/index";
    }
}
