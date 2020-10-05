package com.example.projectpfa.Service.ServiceImpl;

import com.example.projectpfa.Exception.InvalidIdException;
import com.example.projectpfa.DAO.TermsRepository;
import com.example.projectpfa.Service.InterfaceService.TermsService;
import com.example.projectpfa.entities.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TermsServiceImpl implements TermsService {
    @Autowired
    TermsRepository termsRepository;
    @Override
    public List<Terms> list() {
        return termsRepository.findAll();
    }

    @Override
    public Terms get(int id) {
        Optional<Terms> terms = termsRepository.findById(id);
        return terms.orElseThrow(InvalidIdException::new);
    }



    @Override
    public Terms save(Terms terms) {
        termsRepository.saveAndFlush(terms);
        return terms;
    }
    @Override
    public Terms update(Terms terms) {
        termsRepository.saveAndFlush(terms);
        return terms;
    }

    @Override
    public void delete(int id) {
        Optional<Terms> terms = termsRepository.findById(id);
        if(terms.isPresent()){
            termsRepository.deleteById(id);
        }else{
            throw  new InvalidIdException();
        }

    }

    @Override
    public Terms getVersion(String version) {
       Terms terms = termsRepository.findByVersionTerms(version);
        return terms;
    }


}
