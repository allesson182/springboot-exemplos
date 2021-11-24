package br.ifpe.web2.controller;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/addgrupo")
    public String adicionarGrupo(Grupo grupo, Model model) {
            grupoService.adicionarGrupo(grupo);
            return "redirect:/grupos";


    }

    @GetMapping("/grupoedit")
    public String editarGrupo(Long id, Model model){
        Grupo grupoParaEditar = grupoService.getGrupoById(id);
        model.addAttribute("grupo", grupoParaEditar);
        return "cadastro-grupo";

    }

    @GetMapping("/delgrupo")
    public String deletarGrupo(Long id, Model model){
        try {
            grupoService.deletarGrupo(id);
            return "redirect:/grupos";
        }catch (Exception e) {
            model.addAttribute("Erro", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/addgrupo")
    public String cadastroGrupo(Grupo grupo){

        return "cadastro-grupo";
    }


}
