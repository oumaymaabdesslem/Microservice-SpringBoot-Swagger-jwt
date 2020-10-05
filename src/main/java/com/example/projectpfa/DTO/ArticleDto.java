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
public class ArticleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private LocalDate createdDate;
    private Boolean publisched;
}
