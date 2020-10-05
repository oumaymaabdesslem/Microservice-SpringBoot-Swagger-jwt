package com.example.projectpfa.DAO;

import com.example.projectpfa.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
