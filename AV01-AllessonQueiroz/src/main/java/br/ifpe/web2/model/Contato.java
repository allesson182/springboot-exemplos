package br.ifpe.web2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	@ElementCollection
	private ArrayList<String>apps;
	private String grupo;
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
	public ArrayList<String> getApps() {
		return apps;
	}
	public void setApps(ArrayList<String> apps) {
		this.apps = apps;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
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
