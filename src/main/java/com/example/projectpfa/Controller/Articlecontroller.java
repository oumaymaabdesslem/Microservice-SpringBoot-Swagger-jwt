package com.example.projectpfa.Controller;


import com.example.projectpfa.DTO.ArticleDto;
import com.example.projectpfa.Mapper.ArticleMapper;
import com.example.projectpfa.Service.InterfaceService.ArticleService;
import com.example.projectpfa.entities.Article;
import com.example.projectpfa.restResponse.GenericResponse;
import com.example.projectpfa.restResponse.ResponseBuilder;
import com.example.projectpfa.restResponseBody.ListResponse;
import com.example.projectpfa.restResponseBody.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/articles")
@Api( description = "Operations pertaining to articles")
@CrossOrigin
public class Articlecontroller {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleMapper articleMapper;

    @ApiOperation(value = "View a list of available articles", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("art")
    public List<ArticleDto> findall() throws Exception{
        List<ArticleDto> result = new ArrayList<>();
        List<Article> articleList = articleService.list();

        if(articleList !=null && articleList.size()>0){
            for(Article article : articleList){
                ArticleDto articleDto = articleMapper.convertToDto(article);
                result.add(articleDto);
            }
        }
     //return ResponseBuilder.buildSuccessResponse(new ListResponse(result));
         return  result;
    }

    @ApiOperation(value = "Search a article with an ID",response = Article.class)
    @GetMapping(value = "/art/{id}")
    public GenericResponse findarticle(@PathVariable("id") Integer id ){
         Article article = articleService.get(id);
         ArticleDto articleDto = articleMapper.convertToDto(article);
      return ResponseBuilder.buildSuccessResponse(new ObjectResponse(articleDto));

    }


    @ApiOperation(value = "Add a article")
    @PostMapping(value = "/add")
   public GenericResponse createarticle(@RequestBody Article article){
      articleService.save(article);
      return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
   }

   @ApiOperation(value = "Update a article")
   @PutMapping(value = "/art/{id}")
   public GenericResponse updatearticle(@RequestBody Article article){
     articleService.update(article);
       return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
   }

   @ApiOperation(value = "Delete a article")
   @DeleteMapping(value = "/art/{id}")
   public GenericResponse deletearticle(@PathVariable("id") Integer id){
        articleService.delete(id);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
   }

}
