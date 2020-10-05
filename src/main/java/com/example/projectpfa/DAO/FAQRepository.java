package com.example.projectpfa.DAO;

import com.example.projectpfa.entities.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Integer> {
    FAQ findByFaqName (String faqname);
}
