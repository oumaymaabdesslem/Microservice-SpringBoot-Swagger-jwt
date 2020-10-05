package com.example.projectpfa.entities;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.PipedReader;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "FAQ")
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "FAQ_GENERATOR")
    @Column(name = "ID")
    @ApiModelProperty(notes = "The database generated FAQ ID")
    private Integer id;

    @Column(name = "TopicName")
    @NotBlank
    @NotEmpty
    @NotNull
    @ApiModelProperty(notes = "The database generated TopicName")
    private String topicName;

    @ManyToOne(cascade=CascadeType.ALL )
    private Question question;
}

