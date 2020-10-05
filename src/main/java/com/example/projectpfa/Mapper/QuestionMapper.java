package com.example.projectpfa.Mapper;

import com.example.projectpfa.DTO.QuestionDto;
import com.example.projectpfa.entities.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    @Autowired
    private ModelMapper modelMapper;

    public QuestionDto convertToDto (Question question){
        QuestionDto questiondto =modelMapper.map(question,QuestionDto.class);
        return questiondto;
    }

    public Question convertToEntity (QuestionDto questionDto){
        Question question = modelMapper.map(questionDto,Question.class);
        return question;
    }

}
