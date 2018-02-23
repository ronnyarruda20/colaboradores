package br.com.consignum.colaboradores.repository;

import javax.enterprise.context.RequestScoped;

import br.com.consignum.colaboradores.models.Endereco;

@RequestScoped
public class EnderecoRepository extends Repository<Endereco> {

	public EnderecoRepository() {
		super.setType(Endereco.class);
	}


}
