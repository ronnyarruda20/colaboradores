package br.com.consignum.colaboradores.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ESTADO", length = 100, nullable = false)
	private String uf;

	@Column(name = "CIDADE", length = 100, nullable = false)
	private String cidade;

	@Column(name = "BAIRRO", length = 100, nullable = false)
	private String bairro;

	@Column(name = "RUA", length = 100, nullable = false)
	private String logradouro;

	@Column(name = "NUMERO", length = 2, nullable = false)
	private String numero;

	@Column(name = "CEP", length = 8, nullable = false)
	private String cep;

	@Column(name = "COMPLEMENTO", length = 8, nullable = false)
	private String complemento;

	@Transient
	private String localidade;
	@Transient
	private String unidade;
	@Transient
	private String ibge;
	@Transient
	private String gia;

	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", uf=" + uf + ", cidade=" + cidade + ", bairro=" + bairro + ", logradouro="
				+ logradouro + ", numero=" + numero + ", cep=" + cep + ", complemento=" + complemento + ", localidade="
				+ localidade + ", unidade=" + unidade + ", ibge=" + ibge + ", gia=" + gia + ", pessoa=" + pessoa + "]";
	}
	
}
