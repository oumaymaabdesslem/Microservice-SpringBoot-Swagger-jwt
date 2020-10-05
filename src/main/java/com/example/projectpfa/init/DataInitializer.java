package com.example.projectpfa.init;

import com.example.projectpfa.DAO.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    ArticleRepository articleRepository ;

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    TopicRepository topicRepository;
   @Autowired
    TermsRepository termsRepository;
   @Autowired
   FAQRepository faqRepository;
   @Autowired
    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;




    @Override
    public void run(String... args) throws Exception {
/*
        articleRepository.save(Article.builder().title("Article 1").publisched(true).description("Tutorial Spring Boot").createdDate(LocalDate.of(2020, Month.DECEMBER,
                25)).build());
        articleRepository.save(Article.builder().title("Article 2").publisched(true).description("Tutorial Angular").createdDate(LocalDate.of(2019, Month.DECEMBER,25)).build());
        articleRepository.save(Article.builder().title("Article 3").publisched(true).description("Tutorial Node js").createdDate(LocalDate.of(2021, Month.DECEMBER,25)).build());

         termsRepository.save(Terms.builder().contentTerms("fghjjklkm").date(LocalDate.of(2021, Month.DECEMBER,25)).isDraft(false).langueTerms("Englich").versionTerms("v1").build());*/


      /*  User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(this.passwordEncoder.encode("admin"));
        admin.setEmail("admin@email.com");
        admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

         userRepository.save(admin);

        User client = new User();
        client.setUsername("client");
        client.setPassword(this.passwordEncoder.encode("client"));
        client.setEmail("client@email.com");
        client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
        userRepository.save(client);*/
    }

}

