package br.ifpe.web2.controller;

import java.util.ArrayList;
import java.util.List;

import br.ifpe.web2.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Contato;

@Controller
public class ContatoController {

	@Autowired
	ContatoService contatoService;

	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato) {
		return "contatos-form";
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		contatoService.adicionarContato(contato);
		System.out.println(contato);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		ArrayList<Contato> listaContatos = contatoService.listarContatos();
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
