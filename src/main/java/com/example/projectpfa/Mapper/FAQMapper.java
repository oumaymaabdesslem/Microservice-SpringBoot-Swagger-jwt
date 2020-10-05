package com.example.projectpfa.Mapper;


import com.example.projectpfa.DTO.FAQDto;
import com.example.projectpfa.DTO.TopicDto;
import com.example.projectpfa.entities.FAQ;
import com.example.projectpfa.entities.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FAQMapper {
    @Autowired
    private ModelMapper modelMapper;

    public FAQDto convertToFaqDto (FAQ faq){
        FAQDto faqDto = modelMapper.map(faq,FAQDto.class);
        return faqDto;
    }

    public FAQ convertToFaqEntity(FAQDto faqDto){
        FAQ faq = modelMapper.map(faqDto,FAQ.class);
        return faq;
    }

}
