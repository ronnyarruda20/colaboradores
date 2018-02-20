package br.com.consignum.colaboradores.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private Date nascimento;
	
	@Column(name = "REGISTRO_GERAL", length = 9, nullable = false)
	private String registroGeral;
	
	@Column(name = "EMAIL", length = 100, nullable = false)
	private String email;
	
	@OneToOne(mappedBy = "pessoa")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<InfoBancario> bancos = new HashSet<InfoBancario>();
	
	@Transient
	private List<InfoBancario> bancoList = new ArrayList<InfoBancario>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<InfoBancario> getBancos() {
		return bancos;
	}

	public void setBancos(Set<InfoBancario> bancos) {
		this.bancos = bancos;
	}

	public List<InfoBancario> getBancoList() {
		return bancoList;
	}

	public void setBancoList(List<InfoBancario> bancoList) {
		this.bancoList = bancoList;
	}
	
	
}
