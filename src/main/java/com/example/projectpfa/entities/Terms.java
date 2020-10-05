package com.example.projectpfa.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Conditions")
public class Terms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LangueTerms")
    @NotBlank
    @NotEmpty
    @NotNull
    private String langueTerms;

    @Column(name = "Date")
    @NotBlank
    @NotEmpty
    @NotNull
    private LocalDate date;


    @Column(name = "VersionTerms")
    @NotBlank
    @NotEmpty
    @NotNull
    private String versionTerms;

    @Column(name = "ContentTerms")
    @NotBlank
    @NotEmpty
    @NotNull
    private String contentTerms;


    @Column(name = "isDraft")
    private Boolean isDraft;
}
