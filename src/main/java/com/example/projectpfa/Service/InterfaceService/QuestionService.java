package com.example.projectpfa.Service.InterfaceService;



import com.example.projectpfa.entities.Question;

import java.util.List;

public interface QuestionService {
    List<Question> list();
    Question get(int id);
    Question save(Question question);
    Question update(Question question);
    void delete(int id);
}
