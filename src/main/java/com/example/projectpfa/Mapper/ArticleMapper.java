package com.example.projectpfa.Mapper;

import com.example.projectpfa.DTO.ArticleDto;
import com.example.projectpfa.entities.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    @Autowired
    private  ModelMapper modelMapper;

    public ArticleDto convertToDto (Article article){
        ArticleDto articleDto = modelMapper.map(article,ArticleDto.class);
        return articleDto;
    }

    public Article convertToEntity(ArticleDto articleDto){
        Article article = modelMapper.map(articleDto,Article.class);
        return article;
    }


}
