package br.com.consignum.colaboradores.controllers;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;

import br.com.consignum.colaboradores.models.Pessoa;
import br.com.consignum.colaboradores.repository.PessoaRepository;

@Named("pessoaController")
@ViewScoped
public class PessoaController  implements Serializable {

	private static final long serialVersionUID = 8221389380643774417L;

	private Long id;

	private String valor;

	@Inject
	private PessoaRepository pessoaRepository;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return "Ronny";
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void lista() {
		Pessoa p = new Pessoa();
		p.setNome("Ronny de Arruda");
		p.setEmail("ronnyapinho@gmail.com");
		p.setNascimento(new DateTime(1988,01,26, 0, 0).toDate());
		p.setRegistroGeral("17218551");
		Pessoa pi = pessoaRepository.merge(p);
		System.out.println(pi.getId());
		System.out.println(pessoaRepository.findAll());
//		System.out.println(pessoaRepository.find(pi).getNome());
	}

}
