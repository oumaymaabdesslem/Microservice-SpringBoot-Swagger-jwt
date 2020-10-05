package com.example.projectpfa.DAO;

import com.example.projectpfa.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer> {
    Topic findByTopicName(String topicname);
}
