package com.example.projectpfa.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "articles")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "ARTICLE_GENERATOR",sequenceName = "ARTICLE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ARTICLE_GENERATOR")
    @Column(name = "ID")
    @ApiModelProperty(notes = "The database generated article ID")
    private Integer id;

    @Column(name = "Title")
    @Size(min = 1,max = 5)
    @NotBlank
    @NotEmpty
    @NotNull
    @ApiModelProperty(notes = "The Title of the article")
    private String title;

    @Column(name = "Description")
    @ApiModelProperty(notes = "The description of the article")
    private String description;

    @Column(name = "CreatedDate")
    @ApiModelProperty(notes = "The CreatedDate of the article")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;


    @Column(name = "Publisched")
    @ApiModelProperty(notes = "The CreatedDate of the article")
    private Boolean publisched;



}
