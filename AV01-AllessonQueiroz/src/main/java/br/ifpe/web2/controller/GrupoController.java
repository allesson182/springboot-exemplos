package br.ifpe.web2.controller;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @GetMapping("/grupos")
    public String listarGrupos(Model model){
        List<Grupo> todosGrupos = grupoService.getAllGrupos();
        model.addAttribute("listaGrupo", todosGrupos);
        return "grupos";
    }
}
