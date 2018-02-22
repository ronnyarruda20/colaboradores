package br.com.consignum.colaboradores.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consignum.colaboradores.models.Endereco;
import br.com.consignum.colaboradores.models.Pessoa;
import br.com.consignum.colaboradores.repository.PessoaRepository;
import br.com.consignum.colaboradores.services.RestService;

@Named("manterColaboradorController")
@ViewScoped
public class ManterColaboradorController extends Controller {

	private static final long serialVersionUID = 8221389380643774417L;
	
	private static final String MANTER_COLABORADOR = "/resources/paginas/cadastrarColaborador";
	
	private Long id;

	private Pessoa pessoa = new Pessoa();

	@Inject
	private PessoaRepository pessoaRepository;
	
	
	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		pessoa.setEndereco(new Endereco());
		pessoa.setNome("Fulano da silva");
		pessoa.setEmail("fulano@fulano.com");
		pessoa.setNascimento(new Date());
		pessoa.setRegistroGeral("390532393");
//		pessoa.getEndereco().setBairro("Recanto ");
//		pessoa.getEndereco().setUf("Mato-grosso");
//		pessoa.getEndereco().setCidade("Cuiaba");
//		pessoa.getEndereco().setCep("78074116");
//		pessoa.getEndereco().setNumero("15");
//		pessoa.getEndereco().setLogradouro("Rua gralha");
	}
	
	private void carregar() {
		this.pessoa = (Pessoa) pessoaRepository.find(pessoa.getId());
	}
	
	public String adicionar(Pessoa pessoa) {
		if(pessoa == null) {
			return null;
		}
		pessoaRepository.merge(pessoa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro incluido com sucesso", "PrimeFaces Rocks."));
		return "/resources/paginas/pesquisarColaborador";
	}
	
	public String editar(Pessoa pessoa) {
		this.pessoa = pessoa;
		this.carregar();
		setModoAlteracao();
		return MANTER_COLABORADOR;
	}
	
	public String visualizar(Pessoa pessoa) {
		this.pessoa = pessoa;
		this.carregar();
		setModoVisualizacao();
		return MANTER_COLABORADOR;
	}
	
	public String alterar(Pessoa pessoa) {
		this.pessoa = (Pessoa) pessoaRepository.find(pessoa);
		pessoaRepository.merge(pessoa);
		addInfoMessage("Registro alterado com sucesso");
		return "/resources/paginas/pesquisarColaborador";
	}

	public String remover(Pessoa pessoa) {
		pessoa = pessoaRepository.merge(pessoa);
		pessoaRepository.remove(pessoa);
		addInfoMessage("Registro exluido com sucesso");
		return "/resources/paginas/pesquisarColaborador";
	}
	
	public void carregaCep() {
		Endereco  endereco = RestService.buscarCep(this.pessoa.getEndereco().getCep());
		this.pessoa.setEndereco(endereco);
		System.out.println(this.pessoa.getEndereco().toString());
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

}
