package br.ifpe.web2.controller;

import java.util.ArrayList;
import java.util.List;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.model.Visibilidade;
import br.ifpe.web2.services.ContatoService;
import br.ifpe.web2.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoController {

	@Autowired
	ContatoService contatoService;
	@Autowired
	GrupoService grupoService;

	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato, Model model) {
		List<Grupo> listaGrupo = grupoService.getAllGrupos();
		model.addAttribute("listaGrupos", listaGrupo);
		return "contatos-form";
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		if (contato.getId() == null ){
			if(contato.getGrupo() == null || contato.getGrupo().equals("")){
				contatoService.adicionarContato(contato);
				return "redirect:/listarContatos";
			}
			Grupo grupo = grupoService.getGrupoById(contato.getGrupo().getId());
			contato.setGrupo(grupo);
			contatoService.adicionarContato(contato);
		}else if (contato.getId() != null){
			contatoService.editarContato(contato);
		}
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		List<Contato> listaContatos = contatoService.listarContatos();
		model.addAttribute("lista", listaContatos);
		return "contatos-list";
	}
	
	@GetMapping("/removerContato")
	public String removerContato(String email) {
		contatoService.deletarContato(email);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/editarContato")
	public String editarContato(String email, Model model) {
		Contato contatoParaEditar = contatoService.getContatoByEmail(email);
		model.addAttribute("contato", contatoParaEditar);
		return "contatos-form";
	}

}
