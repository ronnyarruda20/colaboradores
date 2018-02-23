package br.com.consignum.colaboradores.services;

import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.consignum.colaboradores.models.BancoPojo;
import br.com.consignum.colaboradores.models.Endereco;

public class RestService {

	public static Endereco buscarCep(String cep) {
		if (cep == null) {
			return null;
		}
		Client client = ClientBuilder.newClient();
		Builder builder = client.target("https://viacep.com.br/ws/" + cep + "/json/").request(MediaType.APPLICATION_JSON);
		Endereco endereco = builder.get(Endereco.class);
		return endereco;
	}

	public static List<BancoPojo> listaTodosBancos() {
		String url = "https://gist.githubusercontent.com/matheus-santos/29413d209af703f2d3e6d48e8f27fbe6/raw/5acf455c11dbb8690b0eb1af1a644373780c8e07/banks_BR.json";
		Client client = ClientBuilder.newClient();
		Builder builder = client.target(url).request(MediaType.APPLICATION_JSON);
		String json = builder.get(String.class);
		Gson gson = new Gson();
		Type listType = new TypeToken<List<BancoPojo>>() {}.getType();
		@SuppressWarnings("unchecked")
		List<BancoPojo> listaBanco =  (List<BancoPojo>) gson.fromJson(json,  listType);
		return listaBanco;
	}
	
//	public static List<String> listaTodosBancosString() {
//		String url = "https://gist.githubusercontent.com/matheus-santos/29413d209af703f2d3e6d48e8f27fbe6/raw/5acf455c11dbb8690b0eb1af1a644373780c8e07/banks_BR.json";
//		Client client = ClientBuilder.newClient();
//		Builder builder = client.target(url).request(MediaType.APPLICATION_JSON);
//		String json = builder.get(String.class);
//		return json;
//	}
}

