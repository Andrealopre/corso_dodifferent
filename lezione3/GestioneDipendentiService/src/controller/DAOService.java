package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.stream.Collectors;

import model.Dipendente;


public class DAOService { //Data Access Object, classe specializzata a gestire il CRUD del repository
	private ArrayList<Dipendente> repositoryDipendente = new ArrayList<>();
	private final String FILE_PATH = "src/resource/dipendenti.csv";
	
	public ArrayList<Dipendente> getRepositoryDipendente() {
		return repositoryDipendente;
	}
	
	// Inserimento (Create)
	public void inserimento(Dipendente dip) {
		repositoryDipendente.add(dip);
	}
	
	// Modifica (Update)
	public void modifica(int indice, Dipendente dip) {
		this.repositoryDipendente.set(indice, dip);
	}
	
	// Cancellazione (Delete)
	public void cancella(Dipendente dip) {
		this.repositoryDipendente.remove(dip);
	}
	
	// Cerca (Read-Entità)
	public Dipendente cerca(int id) {
		for(Dipendente dip : this.repositoryDipendente) {
			if(dip.getId() == id) {
				return dip;
			}
		}
		return null;
	}
	
	public ArrayList<Dipendente> cerca(String cognome, String nome) {
		ArrayList<Dipendente> dipendentiTrovati = new ArrayList<>();
		for(Dipendente dip : this.repositoryDipendente) {
			if(cognome.equals(dip.getCognome()) && nome.equals(dip.getNome())) {
				dipendentiTrovati.add(dip);
			}
		}
		return dipendentiTrovati;
	}
	
	public ArrayList<Dipendente> cercaBis(String cognome, String nome) {
		ArrayList<Dipendente> dipendentiTrovati = this.repositoryDipendente
				.stream()
				.filter(p -> p.getNome().equals(nome)
				&& p.getCognome().equals(cognome))
				.collect(Collectors.toCollection(ArrayList::new));
		return dipendentiTrovati;
	}
	
	public boolean salva() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (Dipendente dip : this.repositoryDipendente) {

				bw.write(
						/*
						dip.getId() + ";" +
						dip.getNome() + ";" +
						dip.getCognome() + ";" +
						dip.getLuogoDiNascita() + ";" +
						dip.getDataDiNascita() + ";" +
						dip.getSesso() + ";" +
						dip.getCodiceFiscale() + ";" +
						dip.getTitoloDiStudio() + ";" +
						dip.getRuoloAziendale() + ";" +
						dip.getStipendio()
						*/
						dip.toString()
					);

				bw.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean carica() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String riga;

			while ((riga = br.readLine()) != null) {

				String[] dati = riga.split(";");
				Dipendente dip = new Dipendente();

				dip.setId(Integer.parseInt(dati[0]));
				dip.setNome(dati[1]);
				dip.setCognome(dati[2]);
				dip.setLuogoDiNascita(dati[3]);
				dip.setDataDiNascita(Date.valueOf(dati[4]));
				dip.setSesso(dati[5]);
				dip.setCodiceFiscale(dati[6]);
				dip.setTitoloDiStudio(dati[7]);
				dip.setRuoloAziendale(dati[8]);
				dip.setStipendio(Double.valueOf(dati[9]));
			
				this.inserimento(dip);
			}

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public boolean verificaId(int id) {
		Dipendente risultato = this.repositoryDipendente
				.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElse(null);
		if(risultato != null) {
			return true;
		}
		return false;
	}
	
	public DAOService() {
		this.carica();
	}
}
