package br.ifpe.web2.dao;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.model.Visibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface GrupoDao extends JpaRepository<Grupo, Long> {
//ajustar
    public List<Grupo> findGrupoByVisibilidadeEquals(Visibilidade visibilidade);
    public List<Grupo> findGrupoByDataExpiracaoAfterOrDataExpiracaoIsNull(Date date);
}
