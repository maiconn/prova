package br.com.hbsis.prova.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.hbsis.prova.model.Cidade;

public class CidadeDAO {
	public List<Cidade> recuperarCidades() {
		try {
			File file = new File("DB.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			List<Cidade> cidades = new ArrayList<Cidade>();
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				cidades.add(new Cidade(scan.nextLine()));
			}
			scan.close();
			return cidades;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void inserirCidade(String cidade) {
		try {
			File file = new File("DB.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(cidade);
			writer.newLine();
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
