package egorov.com.salesdepartmentsystem.controllers;

import egorov.com.salesdepartmentsystem.excel.TypeOfGoodsExcelGenerator;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.services.TypeOfGoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TypeOfGoodsController {
    private final TypeOfGoodsService typeOfGoodsService;

    @GetMapping("/typeofgoods/index")
    public String getAllRecords(Model model) {
        model.addAttribute("typeofgoods", typeOfGoodsService.findAll());
        return findPaginated(1, model);
    }

    @GetMapping("/typeofgoods/create")
    public String createNewRecord(Model model) {
        TypeOfGoods typeOfGoods = new TypeOfGoods();
        model.addAttribute("typeofgoods", typeOfGoods);
        return "typeofgoods/create";
    }

    @PostMapping("/typeofgoods/save")
    public String saveRecord(@ModelAttribute("typeofgoods") TypeOfGoods typeOfGoods) {
        typeOfGoodsService.save(typeOfGoods);
        return "redirect:/typeofgoods/index";
    }

    @GetMapping("/typeofgoods/edit/{id}")
    public String editRecord(@PathVariable(value = "id") int id, Model model) {
        TypeOfGoods typeOfGoods = typeOfGoodsService.getTypeOfGoodsById(id);
        model.addAttribute("typeofgoods", typeOfGoods);
        return "typeofgoods/edit";
    }

    @GetMapping("/typeofgoods/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id) {
        this.typeOfGoodsService.deleteById(id);
        return "redirect:/typeofgoods/index";
    }

    @GetMapping("/typeofgoods/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<TypeOfGoods> page = typeOfGoodsService.findPaginated(pageNo, pageSize);
        List<TypeOfGoods> typeOfGoods = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("typeofgoods", typeOfGoods);
        return "typeofgoods/index";
    }

    @GetMapping("/typeofgoods/exportToExcel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=typeofgoods" + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<TypeOfGoods> typeOfGoodsList = typeOfGoodsService.findAll();
        TypeOfGoodsExcelGenerator generator = new TypeOfGoodsExcelGenerator(typeOfGoodsList);
        generator.generateExcelFile(response);
    }
}
