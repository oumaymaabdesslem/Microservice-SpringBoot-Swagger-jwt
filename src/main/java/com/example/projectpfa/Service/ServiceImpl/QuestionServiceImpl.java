package com.example.projectpfa.Service.ServiceImpl;

import com.example.projectpfa.Exception.InvalidIdException;
import com.example.projectpfa.DAO.QuestionRepository;
import com.example.projectpfa.Service.InterfaceService.QuestionService;
import com.example.projectpfa.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@CrossOrigin("*")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> list() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(int id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.orElseThrow(InvalidIdException::new);
    }

    @Override
    public Question save(Question question) {
        questionRepository.saveAndFlush(question);
        return question;
    }

    @Override
    public Question update(Question question) {
        questionRepository.saveAndFlush(question);
        return question;
    }
    @Override
    public void delete(int id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            questionRepository.deleteById(id);
        }else{
            throw new InvalidIdException();
        }

    }
}
