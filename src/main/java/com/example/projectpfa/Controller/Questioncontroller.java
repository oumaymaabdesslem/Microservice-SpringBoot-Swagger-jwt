package com.example.projectpfa.Controller;

import com.example.projectpfa.DTO.QuestionDto;
import com.example.projectpfa.Mapper.QuestionMapper;
import com.example.projectpfa.Service.InterfaceService.QuestionService;
import com.example.projectpfa.entities.Article;
import com.example.projectpfa.entities.Question;
import com.example.projectpfa.restResponse.GenericResponse;
import com.example.projectpfa.restResponse.ResponseBuilder;
import com.example.projectpfa.restResponseBody.ListResponse;
import com.example.projectpfa.restResponseBody.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api( description = "Operations pertaining to Questions")
@RequestMapping("/question")
public class Questioncontroller {

    @Autowired
    QuestionService questionService;


    @Autowired
    QuestionMapper questionMapper;



    @ApiOperation(value = "View a list of available questions", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/quest")
    public GenericResponse findall() throws Exception{
        List<QuestionDto> result = new ArrayList<>();
        List<Question> questionList = questionService.list();

        if(questionList !=null && questionList.size()>0){
            for(Question question : questionList){
                QuestionDto questionDto = questionMapper.convertToDto(question);
                result.add(questionDto);
            }
        }
        return ResponseBuilder.buildSuccessResponse(new ListResponse(result));
    }

    @ApiOperation(value = "Search a Question with an ID",response = Article.class)
    @GetMapping(value = "/question/{id}")
    public GenericResponse findquestion(@PathVariable("id") Integer id ){
        Question question = questionService.get(id);
        QuestionDto questionDto = questionMapper.convertToDto(question);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(questionDto));
    }

    @ApiOperation(value = "Add a Question")
    @PostMapping(value = "/question")
    public GenericResponse createquestion(@RequestBody Question question){
        questionService.save(question);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Update a Question")
    @PutMapping(value = "/question/{id}")
    public GenericResponse updatequestion(@RequestBody Question question){
        questionService.update(question);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Delete a Question")
    @DeleteMapping(value = "/question/{id}")
    public GenericResponse deletequestion(@PathVariable("id") Integer id){
        questionService.delete(id);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

}
