package com.example.projectpfa.Mapper;

import com.example.projectpfa.DTO.TermsDto;
import com.example.projectpfa.entities.Terms;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TermsMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TermsDto convertToDto (Terms terms){
        TermsDto termsDto = modelMapper.map(terms,TermsDto.class);
        return termsDto;
    }

    public Terms convertToEntity(TermsDto termsDto){
        Terms terms = modelMapper.map(termsDto,Terms.class);
        return terms;
    }
}
