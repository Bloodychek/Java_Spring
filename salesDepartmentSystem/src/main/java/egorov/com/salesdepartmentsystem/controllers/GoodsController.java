package egorov.com.salesdepartmentsystem.controllers;

import egorov.com.salesdepartmentsystem.models.Application;
import egorov.com.salesdepartmentsystem.models.Goods;
import egorov.com.salesdepartmentsystem.models.TypeOfGoods;
import egorov.com.salesdepartmentsystem.services.ApplicationService;
import egorov.com.salesdepartmentsystem.services.GoodsService;
import egorov.com.salesdepartmentsystem.services.TypeOfGoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;
    private final ApplicationService applicationService;
    private final TypeOfGoodsService typeOfGoodsService;
    @GetMapping("/goods/index")
    public String getAllRecords(Model model){
        model.addAttribute("goods", goodsService.findAll());
        return findPaginated(1, model);
    }

    @GetMapping("/goods/create")
    public String createNewRecord(Model model) {
        Goods goods = new Goods();
        model.addAttribute("goods", goods);
        model.addAttribute("applications", applicationService.findAll());
        model.addAttribute("typeofgoods", typeOfGoodsService.findAll());
        return "goods/create";
    }

    @GetMapping("/goods/edit/{id}")
    public String editRecord(@PathVariable(value = "id") int id, Model model) {
        Goods goods = goodsService.getGoodsById(id);
        Application application = applicationService.getApplicationById(id);
        TypeOfGoods typeOfGoods = typeOfGoodsService.getTypeOfGoodsById(id);
        model.addAttribute("goods", goods);
        model.addAttribute("applications", application);
        model.addAttribute("typeofgoods", typeOfGoods);
        return "goods/edit";
    }

    @GetMapping("/goods/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id){
        this.goodsService.deleteById(id);
        return "redirect:/goods/index";
    }

    @PostMapping("/goods/save")
    public String saveRecord(@ModelAttribute("goods") Goods goods) {
        goodsService.save(goods);
        return "redirect:/goods/index";
    }

    @GetMapping("/goods/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Goods> page = goodsService.findPaginated(pageNo, pageSize);
        List<Goods> goods = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("goods", goods);
        return "goods/index";
    }
}
