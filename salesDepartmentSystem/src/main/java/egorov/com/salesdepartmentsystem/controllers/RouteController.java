package egorov.com.salesdepartmentsystem.controllers;

import egorov.com.salesdepartmentsystem.models.Customer;
import egorov.com.salesdepartmentsystem.models.Route;
import egorov.com.salesdepartmentsystem.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RouteController {
    private final RouteService routeService;

    @GetMapping("/route/index")
    public String getAllRecords(Model model){
        model.addAttribute("route", routeService.findAll());
        return findPaginated(1, model);
    }

    @GetMapping("/route/create")
    public String createNewRecord(Model model){
        Route route = new Route();
        model.addAttribute("route", route);
        return "route/create";
    }

    @GetMapping("/route/edit/{id}")
    public String editRecord(@PathVariable(value = "id") int id, Model model){
        Route route = routeService.getRouteById(id);
        model.addAttribute("route", route);
        return "route/edit";
    }

    @GetMapping("/route/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id){
        this.routeService.deleteById(id);
        return "redirect:/route/index";
    }

    @PostMapping("/route/save")
    public String saveRecord(@ModelAttribute("route") Route route){
        routeService.save(route);
        return "redirect:/route/index";
    }

    @GetMapping("/route/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Route> page = routeService.findPaginated(pageNo, pageSize);
        List<Route> routes = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("route", routes);
        return "route/index";
    }
}
