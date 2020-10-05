package com.example.projectpfa.DTO;


import com.example.projectpfa.entities.FAQ;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String question;
    private String answer;
    private FAQ faq;
}
