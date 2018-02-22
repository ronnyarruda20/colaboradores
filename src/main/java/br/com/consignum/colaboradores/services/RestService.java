package br.com.consignum.colaboradores.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;

import br.com.consignum.colaboradores.models.Endereco;

public class RestService {

	public static Endereco buscarCep(String cep) {
		if(cep == null) {
			return null;
		}
		Client client = ClientBuilder.newClient();
		Builder builder = client.target("https://viacep.com.br/ws/"+cep+"/json/").request(MediaType.APPLICATION_JSON);
		Endereco endereco = builder.get(Endereco.class);
		return endereco;
	}
}
