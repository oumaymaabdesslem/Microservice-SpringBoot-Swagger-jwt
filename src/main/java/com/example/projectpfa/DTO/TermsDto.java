package com.example.projectpfa.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TermsDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String langueTerms;
    private LocalDate date;
    private String versionTerms;
    private String contentTerms;
    private  Boolean isDraft;
}
