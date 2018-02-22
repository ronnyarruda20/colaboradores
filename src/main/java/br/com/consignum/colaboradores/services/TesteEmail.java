package br.com.consignum.colaboradores.services;

import java.io.Serializable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;

import br.com.consignum.colaboradores.models.Endereco;

public class TesteEmail {

	public static void main(String[] args) {
		// String valor = CorreioService.buscarCep("78074116");
		//
		// System.out.println(valor);

		Client client = ClientBuilder.newClient();
		Builder builder = client.target("https://viacep.com.br/ws/78074116/json/").request(MediaType.APPLICATION_JSON);
		Endereco response = builder.get(Endereco.class);
//		String response = builder.get(String.class);
		// response.readEntity(Endereco.class);
//		System.out.println(Entity.json(response));
		System.out.println(response.toString());
	}

}

class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	String cep;
	String logradouro;
	String complemento;
	String bairro;
	String localidade;
	String uf;
	String unidade;
	String ibge;
	String gia;
	
	
}
