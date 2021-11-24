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
		List<Grupo> listaGrupo = grupoService.getGruposDataVigente();
		model.addAttribute("listaGrupos", listaGrupo);
		return "contatos-form";
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		contatoService.adicionarContato(contato);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		List<Contato> listaContatos = contatoService.listarContatos();
		model.addAttribute("lista", listaContatos);
		return "contatos-list";
	}
	
	@GetMapping("/removerContato")
	public String removerContato(Long id) {
		contatoService.deletarContato(id);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/editarContato")
	public String editarContato(Long id, Model model) {
		List<Grupo> listaGrupo = grupoService.getGruposDataVigente();
		model.addAttribute("listaGrupos", listaGrupo);
		Contato contatoParaEditar = contatoService.getContatoById(id);
		model.addAttribute("contato", contatoParaEditar);
		return "contatos-form";
	}

}
