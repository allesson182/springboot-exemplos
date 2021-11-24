package br.ifpe.web2.services;

import br.ifpe.web2.dao.GrupoDao;
import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.model.Visibilidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    GrupoDao grupoDao;

    public List<Grupo> getAllGrupos() {
       return  grupoDao.findAll();

    }
    public  List<Grupo> getAllGruposVisibilidadePublica(){
        return grupoDao.findGrupoByVisibilidadeEquals(Visibilidade.PUBLICO);
    }

    public void adicionarGrupo(Grupo grupo) {
        grupoDao.save(grupo);
    }

    public Grupo getGrupoById(Long id) {
        return grupoDao.findById(id).get();
    }

    public void deletarGrupo(Long id) {
        grupoDao.deleteById(id);
    }

    public void editarGrupo(Grupo grupo){
        grupoDao.save(grupo);
    }

    public List<Grupo> getGruposDataVigente() {
        Calendar calendar = Calendar.getInstance();
        return grupoDao.findGrupoByDataExpiracaoAfterOrDataExpiracaoIsNull(calendar.getTime());
    }
}
