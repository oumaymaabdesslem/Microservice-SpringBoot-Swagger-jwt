package com.example.projectpfa.Service.ServiceImpl;


import com.example.projectpfa.Exception.InvalidIdException;
import com.example.projectpfa.DAO.ArticleRepository;
import com.example.projectpfa.Service.InterfaceService.ArticleService;
import com.example.projectpfa.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public List<Article> list() {
        return articleRepository.findAll();
    }

    @Override
    public Article get(int id) {
        Optional<Article> articleOpt = articleRepository.findById(id);
        return articleOpt.orElseThrow(InvalidIdException::new);
    }

    @Override
    public Article save(Article article) {
        articleRepository.saveAndFlush(article);
        return article;
    }
    @Override
    public Article update(Article article) {
        articleRepository.saveAndFlush(article);
        return article;
    }


    @Override
    public void delete(int id)  {
        Optional<Article> articleOpt = articleRepository.findById(id) ;

        if(articleOpt.isPresent()){
            articleRepository.deleteById(id);
        }else {
            throw  new InvalidIdException();
        }
    }


}
