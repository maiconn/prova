package br.com.hbsis.prova.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.com.hbsis.prova.controller.PrevisaoController;

@Path("/previsao")
public class PrevisaoService {
	@GET
	@Produces("application/json")
	@Path("{cidade}")
	public String inserirCidade(@PathParam("cidade") String cidade) {
		return String.format("{\"sucess\": \"%b\"}", new PrevisaoController().inserirCidade(cidade));
	}
	
	@GET
	@Produces("application/json")
	public String recuperarCidades() {		
		return new Gson().toJson(new PrevisaoController().recuperarCidades());
	}
	
	
	@GET
	@Produces("application/json")
	@Path("/forecast/{cidade}")
	public String forecast(@PathParam("cidade") String cidade) {
		return new PrevisaoController().getForecast(cidade);
	}
}