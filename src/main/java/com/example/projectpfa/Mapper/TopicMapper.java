package com.example.projectpfa.Mapper;

import com.example.projectpfa.DTO.TopicDto;
import com.example.projectpfa.entities.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TopicDto convertToTopicDto (Topic topic){
        TopicDto topicDto = modelMapper.map(topic,TopicDto.class);
        return topicDto;
    }

    public Topic convertToTopicEntity(TopicDto topicDto){
        Topic topic = modelMapper.map(topicDto,Topic.class);
        return topic;
    }
}
