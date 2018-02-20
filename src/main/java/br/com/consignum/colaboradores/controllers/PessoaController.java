package br.com.consignum.colaboradores.controllers;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.consignum.colaboradores.repository.PessoaRepository;

@Named("pessoaController")
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 8221389380643774417L;

	private PessoaRepository pessoaRepository;


	public void lista() {
		System.out.println(pessoaRepository.findAll());
	}

	
}
