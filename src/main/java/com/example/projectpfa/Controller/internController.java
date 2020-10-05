package com.example.projectpfa.Controller;

import com.example.projectpfa.util.Translator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


@RestController
@RequestMapping(value = "/api")
@Api( description = "Operations pertaining to traduction")
public class internController {
    @Autowired
    MessageSource messageSource;
    @GetMapping()
    public String getMessage(@RequestParam("msg") String msg) {
        return Translator.toLocale(msg);
    }

    @GetMapping("/")
    public String getSource(@RequestHeader("Accept-Language") String local){
      return messageSource.getMessage("hello",null, Locale.forLanguageTag(local));

    }
}
