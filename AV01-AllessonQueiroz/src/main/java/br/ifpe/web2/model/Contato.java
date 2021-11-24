package br.ifpe.web2.model;


import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	@ElementCollection
	@CollectionTable
	private List<String> apps;
	@ManyToOne
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Grupo grupo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	private String estado;

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getApps() {
		return apps;
	}
	public void setApps(List<String> apps) {
		this.apps = apps;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contato{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", telefone='" + telefone + '\'' +
				", apps=" + apps +
				", grupo='" + grupo + '\'' +
				", dataNascimento=" + dataNascimento +
				", estado='" + estado + '\'' +
				'}';
	}
}
