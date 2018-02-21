package br.com.consignum.colaboradores.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consignum.colaboradores.models.Pessoa;
import br.com.consignum.colaboradores.repository.PessoaRepository;

@Named("pessoaController")
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 8221389380643774417L;

	private Long id;

	private Pessoa pessoa;

	private List<Pessoa> pessoaList;

	{
		pessoaList = new ArrayList<Pessoa>();
		pessoaList.addAll(this.pessoaList());
		System.out.println(pessoaList);
	}

	public PessoaController() {
		pessoaList = new ArrayList<Pessoa>();
		pessoaList.addAll(this.pessoaList());
		System.out.println(pessoaList);
	}

	@Inject
	private PessoaRepository pessoaRepository;

	private List<Pessoa> pessoaList() {
		return pessoaRepository.findAll();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}

}
