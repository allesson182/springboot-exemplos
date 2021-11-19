package br.ifpe.web2.dao;

import br.ifpe.web2.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoDao extends JpaRepository<Grupo, Long> {
}
