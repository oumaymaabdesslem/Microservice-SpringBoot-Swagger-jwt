package com.example.projectpfa.Controller;

import com.example.projectpfa.DTO.TopicDto;
import com.example.projectpfa.Mapper.FAQMapper;
import com.example.projectpfa.Mapper.TopicMapper;
import com.example.projectpfa.Service.InterfaceService.TopicService;
import com.example.projectpfa.entities.Topic;
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
@RequestMapping("/topics")
@Api( description = "Operations pertaining to topics")
public class TopicController {
    @Autowired
    TopicService topicService;
    @Autowired
    TopicMapper topicMapper;

    @ApiOperation(value = "View a list of available Topics", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("topic")
    public GenericResponse findall() throws Exception{
        List<TopicDto> result = new ArrayList<>();
        List<Topic> topicList = topicService.list();

        if(topicList !=null && topicList.size()>0){
            for(Topic topic : topicList){
                TopicDto topicDto = topicMapper.convertToTopicDto(topic);
                result.add(topicDto);
            }
        }
        return ResponseBuilder.buildSuccessResponse(new ListResponse(result));
    }

    @ApiOperation(value = "Search a topic with an ID",response = Topic.class)
    @GetMapping(value = "/topic/{id}")
    public GenericResponse findarticle(@PathVariable("id") Integer id ){
        Topic topic = topicService.get(id);
        TopicDto articleDto = topicMapper.convertToTopicDto(topic);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(articleDto));
    }

    @ApiOperation(value = "Add a topic")
    @PostMapping(value = "/addtopic")
    public GenericResponse createarticle(@RequestBody Topic topic){
        topicService.save(topic);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Update a topic")
    @PutMapping(value = "/topic/{id}")
    public GenericResponse updatearticle(@RequestBody Topic topic){
        topicService.update(topic);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }

    @ApiOperation(value = "Delete a topic")
    @DeleteMapping(value = "/topic/{id}")
    public GenericResponse deletearticle(@PathVariable("id") Integer id){
        topicService.delete(id);
        return ResponseBuilder.buildSuccessResponse(new ObjectResponse(true));
    }
}
