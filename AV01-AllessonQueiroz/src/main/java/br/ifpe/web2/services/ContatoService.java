package br.ifpe.web2.services;


import br.ifpe.web2.dao.ContatoDao;
import br.ifpe.web2.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoService {

    @Autowired
    ContatoDao contatoDao;


    public List<Contato> listarContatos(){
        return contatoDao.findAll();
    }

    public Contato getContatoByEmail(String email){
       Contato contato =  contatoDao.findByEmail(email);
       return contato;
    }

    public void editarContato(Contato contatoAtualizado){
       Contato contatoAtual = contatoDao.findByEmail(contatoAtualizado.getEmail());
       contatoAtual.setEmail(contatoAtualizado.getEmail());
       contatoAtual.setEstado(contatoAtualizado.getEstado());
       contatoAtual.setGrupo(contatoAtualizado.getGrupo());
       contatoAtual.setNome(contatoAtualizado.getNome());
       contatoAtual.setEmail(contatoAtualizado.getEmail());
       contatoAtual.setApps(contatoAtualizado.getApps());
       contatoAtual.setTelefone(contatoAtual.getTelefone());
       contatoDao.save(contatoAtual);
    }

    public void deletarContato(String email){
        Contato contatoAtual = contatoDao.findByEmail(email);
        contatoDao.delete(contatoAtual);
    }

    public void adicionarContato(Contato contato){
        contatoDao.save(contato);
    }
}
