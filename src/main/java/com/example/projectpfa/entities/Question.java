package com.example.projectpfa.entities;


import com.example.projectpfa.DTO.FAQDto;
import com.example.projectpfa.DTO.TopicDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "Questions")
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Question")
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 5,max = 20)
    private String question;


    @Column(name = "Answer")
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 10,max = 255)
    private String answer;

    @ManyToOne(cascade=CascadeType.ALL )
    private FAQ faq;

    @Column(name = "Topic")
    @NotBlank
    @NotEmpty
    @NotNull
    @OneToMany(cascade=CascadeType.ALL )
    private Collection<Topic> topics;
}
