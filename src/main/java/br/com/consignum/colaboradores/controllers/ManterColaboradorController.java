package br.com.consignum.colaboradores.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consignum.colaboradores.models.Endereco;
import br.com.consignum.colaboradores.models.Pessoa;
import br.com.consignum.colaboradores.repository.PessoaRepository;
import br.com.consignum.colaboradores.services.RestService;

@Named("manterColaboradorController")
@RequestScoped
public class ManterColaboradorController extends Controller {

	private static final long serialVersionUID = 8221389380643774417L;

	public static final String MANTER_COLABORADOR = "/resources/paginas/cadastrarColaborador";

	private Long id;

	private Pessoa pessoa = new Pessoa();


	@Inject
	private PessoaRepository pessoaRepository;
	

	@PostConstruct
	public void init() {
		 pessoa.setEndereco(new Endereco());
		// pessoa.setNome("Fulano da silva");
		// pessoa.setEmail("fulano@fulano.com");
		// pessoa.setNascimento(new Date());
		// pessoa.setRegistroGeral("390532393");
		// pessoa.getEndereco().setBairro("Recanto ");
		// pessoa.getEndereco().setUf("Mato-grosso");
		// pessoa.getEndereco().setCidade("Cuiaba");
		// pessoa.getEndereco().setCep("78074116");
		// pessoa.getEndereco().setNumero("15");
		// pessoa.getEndereco().setLogradouro("Rua gralha");
	}


	private void carregar() {
		this.pessoa = (Pessoa) pessoaRepository.find(this.pessoa.getId());
	}

	public String adicionar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		addInfoMessage("Registro incluido com sucesso");
		return ListaColaboradorController.LISTAR_COLABORADOR;
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
		return ListaColaboradorController.LISTAR_COLABORADOR;
	}

	public String remover(Pessoa pessoa) {
		pessoa = pessoaRepository.merge(pessoa);
		pessoaRepository.remove(pessoa);
		addInfoMessage("Registro exluido com sucesso");
		return ListaColaboradorController.LISTAR_COLABORADOR;
	}

	public void carregaCep() {
		if (this.pessoa.getEndereco().getCep().length() < 8) {
			addErrorMessage("Cep requer o tamanho de 8 digitos");
			return;
		}
		Endereco endereco = RestService.buscarCep(this.pessoa.getEndereco().getCep());
		if (endereco.isErro()) {
			addErrorMessage("Cep inválido");
			return;
		}
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
