package com.example.projectpfa.Service.InterfaceService;

import com.example.projectpfa.entities.FAQ;

import java.util.List;

public interface FAQService {
    FAQ getFaq(String faqname);
    List<FAQ> list();
    FAQ get(int id);
    FAQ save(FAQ faq);
    FAQ update (FAQ faq);
    void delete(int id);
}
