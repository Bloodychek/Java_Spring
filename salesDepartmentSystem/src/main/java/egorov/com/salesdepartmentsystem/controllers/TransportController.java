package egorov.com.salesdepartmentsystem.controllers;

import egorov.com.salesdepartmentsystem.models.Transport;
import egorov.com.salesdepartmentsystem.services.TransportService;
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
public class TransportController {
    private final TransportService transportService;

    @GetMapping("/transports/index")
    public String getAllRecords(Model model) {
        model.addAttribute("transports", transportService.findAll());
        return findPaginated(1, model);
    }

    @GetMapping("/transports/create")
    public String createNewRecord(Model model) {
        Transport transport = new Transport();
        model.addAttribute("transports", transport);
        return "transports/create";
    }

    @GetMapping("/transports/edit/{id}")
    public String editRecord(@PathVariable(value = "id") int id, Model model) {
        Transport transport = transportService.getTransportById(id);
        model.addAttribute("transports", transport);
        return "transports/edit";
    }

    @GetMapping("/transports/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id) {
        this.transportService.deleteById(id);
        return "redirect:/transports/index";
    }

    @PostMapping("/transports/save")
    public String saveRecord(@ModelAttribute("transports") Transport transport) {
        transportService.save(transport);
        return "redirect:/transports/index";
    }

    @GetMapping("/transports/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Transport> page = transportService.findPaginated(pageNo, pageSize);
        List<Transport> transports = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("transports", transports);
        return "transports/index";
    }
}
