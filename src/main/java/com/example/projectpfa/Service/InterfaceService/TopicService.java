package com.example.projectpfa.Service.InterfaceService;

import com.example.projectpfa.entities.FAQ;
import com.example.projectpfa.entities.Topic;

import java.util.List;

public interface TopicService {
    Topic getTopic (String topicname);
    List<Topic> list();
    Topic get(int id);
    Topic save(Topic topic);
    Topic update (Topic topic);
    void delete(int id);
}
