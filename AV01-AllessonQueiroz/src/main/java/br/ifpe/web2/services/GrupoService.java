package br.ifpe.web2.services;

import br.ifpe.web2.dao.GrupoDao;
import br.ifpe.web2.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    GrupoDao grupoDao;

    public List<Grupo> getAllGrupos() {
       return  grupoDao.findAll();

    }

    public void adicionargrupo(Grupo grupo) {
        grupoDao.save(grupo);
    }

    public Grupo getGrupoById(Long id) {
        return grupoDao.findById(id).get();
    }
}
