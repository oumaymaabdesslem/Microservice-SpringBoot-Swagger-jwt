package com.example.projectpfa.Controller;

import com.example.projectpfa.DTO.FAQDto;
import com.example.projectpfa.Mapper.FAQMapper;
import com.example.projectpfa.Service.InterfaceService.FAQService;
import com.example.projectpfa.entities.FAQ;
import com.example.projectpfa.restResponse.GenericResponse;
import com.example.projectpfa.restResponse.ResponseBuilder;
import com.example.projectpfa.restResponseBody.ListResponse;
import com.example.projectpfa.restResponseBody.ObjectResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/FAQ")
@Api( description = "Operations pertaining to FAQ")
public class FAQController {
    @Autowired
    FAQService faqService;
    @Autowired
    FAQMapper faqMapper;

    @ApiOperation(value = "View a list of available FAQ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("faq")
    public GenericResponse findall() throws Exception{
        List<FAQDto> result = new ArrayList<>();
        List<FAQ> faqList = faqService.list();

        if(faqList !=null && faqList.size()>0){
            for(FAQ faq : faqList){
                FAQDto faqDto = faqMapper.convertToFaqDto(faq);
                result.add(faqDto);
            }
        }
        return ResponseBuilder.buildSuccessResponse(new ListResponse(result));
    }

    @ApiOperation(value = "Search a Faq with an ID",response = FAQ.class)
    @GetMapping(value = "/faq/{id}")
    public GenericResponse findarticle(@PathVariable("id") Integer id ){
        FAQ faq = faqService.get(id);
        FAQDto faqDto = faqMapper.convertToFaqDto(faq);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(faqDto));
    }

    @ApiOperation(value = "Add a FAQ")
    @PostMapping(value = "/addtopic")
    public GenericResponse createarticle(@RequestBody FAQ faq){
        faqService.save(faq);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Update a FAQ")
    @PutMapping(value = "/faq/{id}")
    public GenericResponse updatearticle(@RequestBody FAQ faq){
        faqService.update(faq);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Delete a FAQ")
    @DeleteMapping(value = "/faq/{id}")
    public GenericResponse deletearticle(@PathVariable("id") Integer id){
        faqService.delete(id);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }
}
