package com.example.projectpfa.Service.ServiceImpl;

import com.example.projectpfa.Exception.InvalidIdException;
import com.example.projectpfa.DAO.FAQRepository;
import com.example.projectpfa.Service.InterfaceService.FAQService;
import com.example.projectpfa.entities.FAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FAQServiceImpl implements FAQService {
    @Autowired
    FAQRepository faqRepository;


    @Override
    public FAQ getFaq(String faqname) {
        FAQ faq = faqRepository.findByFaqName(faqname);
        return faq;
    }

    @Override
    public List<FAQ> list() {
        return faqRepository.findAll();
    }

    @Override
    public FAQ get(int id) {
        Optional<FAQ> faqOptional = faqRepository.findById(id);
        return faqOptional.orElseThrow(InvalidIdException::new);
    }

    @Override
    public FAQ save(FAQ faq) {
        faqRepository.saveAndFlush(faq);
        return faq;
    }

    @Override
    public FAQ update(FAQ faq) {
        faqRepository.saveAndFlush(faq);
        return faq;
    }

    @Override
    public void delete(int id) {
        Optional<FAQ> faqOptional = faqRepository.findById(id) ;

        if(faqOptional.isPresent()){
            faqRepository.deleteById(id);
        }else {
            throw  new InvalidIdException();
        }
    }
}
