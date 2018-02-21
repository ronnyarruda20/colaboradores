package br.com.consignum.colaboradores.repository;

import javax.enterprise.context.RequestScoped;

import br.com.consignum.colaboradores.models.Pessoa;

@RequestScoped
public class PessoaRepository extends Repository<Pessoa> {
	
	public PessoaRepository() {
		super.setType(Pessoa.class);
	}
	
}
