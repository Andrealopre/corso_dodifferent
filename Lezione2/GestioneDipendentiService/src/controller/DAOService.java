package controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import model.Dipendente;

public class DAOService { //Data Access Object, classe specializzata a gestire il CRUD del repository
	private ArrayList<Dipendente> repositoryDipendente = new ArrayList<>();
	
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
		ArrayList<Dipendente> dipendentiTrovati = this.repositoryDipendente.stream()
				.filter(p -> p.getNome().equals(nome)
				&& p.getCognome().equals(cognome))
				.collect(Collectors.toCollection(ArrayList::new));
		return dipendentiTrovati;
	}
}
