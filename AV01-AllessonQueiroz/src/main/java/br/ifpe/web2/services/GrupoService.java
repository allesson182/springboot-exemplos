package br.ifpe.web2.services;

import br.ifpe.web2.dao.GrupoDao;
import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.model.Visibilidade;
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

    public void editarGrupo(Grupo grupoAtualizado){
        try {
            Grupo grupoAtual = grupoDao.findById(grupoAtualizado.getId()).get();
            grupoAtual.setNome(grupoAtualizado.getNome());
            grupoAtual.setVisibilidade(grupoAtualizado.getVisibilidade());
            if (grupoAtualizado.getDataExpiracao().equals("") || grupoAtualizado.getDataExpiracao() == null  ){
                grupoDao.save(grupoAtual);
            }else
                grupoAtual.setDataExpiracao(grupoAtualizado.getDataExpiracao());


            grupoDao.save(grupoAtual);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
