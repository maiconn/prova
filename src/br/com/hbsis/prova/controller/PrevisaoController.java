package br.com.hbsis.prova.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import br.com.hbsis.prova.dao.CidadeDAO;
import br.com.hbsis.prova.model.Cidade;
import br.com.hbsis.prova.util.ConfigUtils;

public class PrevisaoController {

	private CidadeDAO cidadeDAO;

	public PrevisaoController() {
		cidadeDAO = new CidadeDAO();
	}

	public boolean inserirCidade(String cidade) {
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(ConfigUtils.getUrlCidade(URLEncoder.encode(cidade)));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			StringBuilder retorno = new StringBuilder();
			String msg = "";
			while ((msg = br.readLine()) != null) {
				retorno.append(msg);
			}

			if (conn.getResponseCode() != 200 || retorno.toString().contains("\"cod\":\"404\"")) {
				return false;
			}
			
			conn.disconnect();
			cidadeDAO.inserirCidade(cidade);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Cidade> recuperarCidades() {
		return cidadeDAO.recuperarCidades();
	}

	public String getForecast(String cidade) {
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(ConfigUtils.getUrlForecast(URLEncoder.encode(cidade)));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new Exception("não foi possível carregar o forecast.");
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			StringBuilder forecast = new StringBuilder();
			String msg = "";
			while ((msg = br.readLine()) != null) {
				forecast.append(msg);
			}
			conn.disconnect();
			
			return forecast.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
