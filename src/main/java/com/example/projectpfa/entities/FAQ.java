package com.example.projectpfa.entities;

import com.example.projectpfa.DTO.QuestionDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "FAQ")
public class FAQ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "FAQ_GENERATOR",sequenceName = "FAQ_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "FAQ_GENERATOR")
    @Column(name = "ID")
    @ApiModelProperty(notes = "The database generated FAQ ID")
    private Integer id;

    @Column(name = "FAQName")
    @NotBlank
    @NotEmpty
    @NotNull
    @ApiModelProperty(notes = "The database generated FAQName")
    private String faqName;
    @OneToMany(cascade=CascadeType.ALL )
    List<Question> questions;
}
