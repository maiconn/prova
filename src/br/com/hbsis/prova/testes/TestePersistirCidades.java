package br.com.hbsis.prova.testes;

import br.com.hbsis.prova.dao.CidadeDAO;
import junit.framework.TestCase;

public class TestePersistirCidades extends TestCase {
	
	/**
	 * Teste responsável por testar a persistencia das cidades em um arquivo texto
	 */
	public void testPersistenciaCidades(){
		//primeira inserção de uma cidade
		CidadeDAO dao = new CidadeDAO();
		dao.inserirCidade("Blumenau");
		assertEquals(dao.recuperarCidades().size(), 1);		
	}
	
}
