package com.example.projectpfa.DAO;

import com.example.projectpfa.entities.Terms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TermsRepository extends JpaRepository<Terms,Integer> {
    public Terms findByVersionTerms(String version);
}
