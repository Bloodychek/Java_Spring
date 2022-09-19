package com.program.firstspringbootmvc.repositories;

import com.program.firstspringbootmvc.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
