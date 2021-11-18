package br.ifpe.web2.dao;

import br.ifpe.web2.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ContatoDao extends JpaRepository<Contato,Long> {

    ArrayList<Contato> findAll();

    Contato findByEmail(String email);
}
