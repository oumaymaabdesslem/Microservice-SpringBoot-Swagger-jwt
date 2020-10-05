package com.example.projectpfa.Controller;

import com.example.projectpfa.DTO.TermsDto;
import com.example.projectpfa.Mapper.TermsMapper;
import com.example.projectpfa.Service.InterfaceService.TermsService;
import com.example.projectpfa.entities.Terms;
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
@RequestMapping("/terms")
@Api( description = "Operations pertaining to terms and conditions")
public class TermsController {
    @Autowired
    TermsService termsService;

    @Autowired
    TermsMapper termsMapper;

    @ApiOperation(value = "View a list of available terms and conditions", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("")
    public GenericResponse findall() throws Exception{
        List<TermsDto> result = new ArrayList<>();
        List<Terms> List = termsService.list();

        if(List !=null && List.size()>0){
            for(Terms terms : List){
                TermsDto termsDto = termsMapper.convertToDto(terms);
                result.add(termsDto);
            }
        }
        return ResponseBuilder.buildSuccessResponse(new ListResponse(result));
    }

    @ApiOperation(value = "Search a terms and condition with an ID",response = Terms.class)
    @GetMapping(value = "/{id}")
    public GenericResponse findterms(@PathVariable("id") Integer id ){
        Terms terms = termsService.get(id);
        TermsDto termsDto = termsMapper.convertToDto(terms);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(termsDto));
    }


    @ApiOperation(value = "Search a terms and condition with an Version",response = Terms.class)
    @GetMapping(value = "/{versionTerms}")
    public GenericResponse findtermsversion(String version ){
        Terms terms = termsService.getVersion(version);
        TermsDto termsDto = termsMapper.convertToDto(terms);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(termsDto));
    }



    @ApiOperation(value = "Add a terms and conditions")
    @PostMapping(value = "/")
    public GenericResponse createterms(@RequestBody Terms terms){
        termsService.save(terms);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Update a terms and conditions")
    @PutMapping(value = "/{id}")
    public GenericResponse updateterms(@RequestBody Terms terms){
        termsService.update(terms);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Delete a terms and conditions")
    @DeleteMapping(value = "/{id}")
    public GenericResponse deleteterms(@PathVariable("id") Integer id){
        termsService.delete(id);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }


}
