package br.ifpe.web2.controller;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @PostMapping("/savegrupo")
    public String adicionarGrupo(Grupo grupo, Model model) {
        // caso possua id, o mesmo sera editado, caso não possua sera adicionado ao banco
        if ( grupo.getId() != null) {
            grupoService.editarContato(grupo);
            return "redirect:/grupos";
        }else {
            try {
                grupoService.adicionargrupo(grupo);
                return "redirect:/grupos";
            } catch (Exception e) {
                model.addAttribute("Erro", e.getMessage());
                return "error";
            }
        }
    }

    @PutMapping("/grupoedit")
    public String editarGrupo(Grupo grupo, Model model){
        Grupo contatoParaEditar = grupoService.getGrupoById(grupo.getId());
        model.addAttribute("grupo", contatoParaEditar);
        return "cadastro-grupo";

    }

    @DeleteMapping("/delgrupo")
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
