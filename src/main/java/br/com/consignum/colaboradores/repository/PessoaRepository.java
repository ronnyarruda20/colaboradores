package br.com.consignum.colaboradores.repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.consignum.colaboradores.models.InfoBancario;
import br.com.consignum.colaboradores.models.Pessoa;

@RequestScoped
public class PessoaRepository extends Repository<Pessoa> {

	@Inject
	private EnderecoRepository enderecoRepository;

	public PessoaRepository() {
		super.setType(Pessoa.class);
	}

	public void save(Pessoa pessoa) {
		Pessoa p = super.merge(pessoa);
		p.getEndereco().setPessoa(p);
		for (InfoBancario b : pessoa.getBancoList()) {
			this.enderecoRepository.getEm().merge(b);
		}
		super.merge(p);
	}

	@Override
	public Pessoa find(Integer id) {
		return super.find(id);
	}
}
