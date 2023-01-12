package egorov.com.salesdepartmentsystem.controllers;

import egorov.com.salesdepartmentsystem.excel.ApplicationExcelGeneration;
import egorov.com.salesdepartmentsystem.models.Application;
import egorov.com.salesdepartmentsystem.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping("/applications/index")
    public String getAllRecords(Model model) {
        model.addAttribute("applications", applicationService.findAll());
        return findPaginated(1, model);
    }

    @GetMapping("/applications/edit/{id}")
    public String editRecord(@PathVariable(value = "id") int id, Model model) {
        Application application = applicationService.getApplicationById(id);
        model.addAttribute("applications", application);
        return "applications/edit";
    }

    @GetMapping("/applications/create")
    public String createNewRecord(Model model) {
        Application application = new Application();
        model.addAttribute("applications", application);
        return "applications/create";
    }

    @PostMapping("/applications/save")
    public String saveRecord(@ModelAttribute("applications") Application application) {
        applicationService.save(application);
        return "redirect:/applications/index";
    }

    @GetMapping("/applications/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id) {
        this.applicationService.deleteById(id);
        return "redirect:/applications/index";
    }

    @GetMapping("/applications/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Application> page = applicationService.findPaginated(pageNo, pageSize);
        List<Application> applications = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("applications", applications);
        return "applications/index";
    }

    @GetMapping("/applications/exportToExcel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=applications" + ".xls";
        response.setHeader(headerKey, headerValue);

        List<Application> applicationList = applicationService.findAll();
        ApplicationExcelGeneration generator = new ApplicationExcelGeneration(applicationList);
        generator.generateExcelFile(response);
    }
}
