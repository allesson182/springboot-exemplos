package br.ifpe.web2.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated
    private Visibilidade visibilidade;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataExpiracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Visibilidade getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(Visibilidade visibilidade) {
        this.visibilidade = visibilidade;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
