package com.example.projectpfa.Service.InterfaceService;


import com.example.projectpfa.entities.Article;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    List<Article> list();
    Article get(int id);
    Article save(Article article);
    Article update (Article article);
    void delete(int id);

    //List<Article> performQuickSearch(String keysearch);
   // List<Article> performAdvancedSearch(Predicate predicate, Pageable pageable);

}
