package br.ifpe.web2.dao;

import br.ifpe.web2.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ContatoDao extends JpaRepository<Contato,Long> {

    List<Contato> findAll();

    Contato findByEmail(String email);
    Contato findContatoByNome(String nome);

}
