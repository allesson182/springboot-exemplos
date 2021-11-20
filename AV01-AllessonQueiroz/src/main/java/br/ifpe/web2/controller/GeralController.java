package br.ifpe.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeralController {

    @GetMapping("/")
    public String home(){

        return "contatos-list";
    }

    @GetMapping("/error")
    public  String error(Model model, Exception e){
        model.addAttribute("erro", e);
        return "error";
    }

}
