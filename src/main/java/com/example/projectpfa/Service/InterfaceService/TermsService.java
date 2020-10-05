package com.example.projectpfa.Service.InterfaceService;

import com.example.projectpfa.entities.Terms;

import java.util.List;

public interface TermsService {
    List<Terms> list();
    Terms get(int id);
    Terms save(Terms terms);
    Terms update(Terms terms);
    void delete(int id);
    Terms getVersion(String version);

}
