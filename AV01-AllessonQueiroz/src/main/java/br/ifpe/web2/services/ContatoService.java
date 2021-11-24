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

    public void editarContato(Contato contato){
           contatoDao.save(contato);
    }

    public void deletarContato(Long id){
        Contato contato = contatoDao.findById(id).get();
        contatoDao.delete(contato);
    }

    public void adicionarContato(Contato contato){
        contatoDao.save(contato);
    }

    public Contato getContatoById(Long id){
        return contatoDao.findById(id).get();
    }
}
