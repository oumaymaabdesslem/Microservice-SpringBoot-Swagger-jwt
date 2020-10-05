package com.example.projectpfa.DTO;


import com.example.projectpfa.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FAQDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String faqName;
    List<Question> questions;
}
