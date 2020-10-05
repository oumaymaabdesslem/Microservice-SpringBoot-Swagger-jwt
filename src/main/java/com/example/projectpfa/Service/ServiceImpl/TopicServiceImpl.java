package com.example.projectpfa.Service.ServiceImpl;

import com.example.projectpfa.Exception.InvalidIdException;
import com.example.projectpfa.DAO.TopicRepository;
import com.example.projectpfa.Service.InterfaceService.TopicService;
import com.example.projectpfa.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;
    @Override
    public Topic getTopic(String topicname) {
        Topic topic = topicRepository.findByTopicName(topicname);
        return topic;
    }

    @Override
    public List<Topic> list() {
        return topicRepository.findAll();
    }

    @Override
    public Topic get(int id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        return topicOptional.orElseThrow(InvalidIdException::new);

    }

    @Override
    public Topic save(Topic topic) {
        topicRepository.saveAndFlush(topic);
        return topic;
    }

    @Override
    public Topic update(Topic topic) {
        topicRepository.saveAndFlush(topic);
        return topic;
    }

    @Override
    public void delete(int id) {
        Optional<Topic> topicOptional = topicRepository.findById(id) ;

        if(topicOptional.isPresent()){
            topicRepository.deleteById(id);
        }else {
            throw  new InvalidIdException();
        }
    }
}
