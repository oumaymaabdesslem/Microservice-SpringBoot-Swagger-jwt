package com.example.projectpfa.DAO;

import com.example.projectpfa.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
   // Article findByTitle(String title);


}
