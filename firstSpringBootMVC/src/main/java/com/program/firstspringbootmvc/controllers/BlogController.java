package com.program.firstspringbootmvc.controllers;

import com.program.firstspringbootmvc.models.Article;
import com.program.firstspringbootmvc.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);

        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Article article = new Article(title, anons, full_text);
        articleRepository.save(article);

        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<Article> article = articleRepository.findById(id);
        List<Article> articleList = new ArrayList<>();
        article.ifPresent(articleList::add);
        model.addAttribute("article", articleList);

        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){
        if(!articleRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Article> article = articleRepository.findById(id);
        List <Article> articleList = new ArrayList<>();
        article.ifPresent(articleList::add);
        model.addAttribute("article", articleList);

        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Article article = articleRepository.findById(id).orElseThrow();
        article.setTitle(title);
        article.setAnons(anons);
        article.setFull_text(full_text);
        articleRepository.save(article);

        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/delete")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        Article article = articleRepository.findById(id).orElseThrow();
        articleRepository.delete(article);

        return "redirect:/blog";
    }
}
