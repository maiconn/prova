package br.com.hbsis.prova.testes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import junit.framework.TestCase;

public class TestesServicosREST extends TestCase {
	/**
	 * Startar a aplicação e executar o teste
	 * 
	 * @throws IOException
	 */
	public void testeRest() throws IOException {

		URL url = new URL("http://localhost:8080/prova/previsao/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		assertEquals(conn.getResponseCode() == 200, true);

		conn.disconnect();

	}

}
