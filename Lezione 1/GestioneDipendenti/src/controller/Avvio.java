package controller;

import java.util.ArrayList;

import model.Dipendente;
import view.Vista;

public class Avvio {

	public static void main(String[] args) {
		int scelta = 0;
		int idCerca;
		String nomeCerca, cognomeCerca;
		Boolean trovato = false;
		String[] campi;
		ArrayList<Dipendente> dipendentiTrovati;
		Vista vista = new Vista();
		Dipendente dipendente;
		ArrayList<Dipendente> repositoryDipendenti = new ArrayList<>();
		
		while(scelta != 5) {
			vista.menu();
			scelta = vista.leggiIntero("Scegli: ");
			
			switch(scelta) {
				case 1:
					dipendente = new Dipendente();
					String risposta = "";
					
					vista.mascheraInserimento(dipendente);
					risposta = vista.leggiStringa("Confermi l'inserimento (s/n)? ");
					if(risposta.equals("s")) {
						vista.schedaDipendente(dipendente);
						repositoryDipendenti.add(dipendente);
						risposta = vista.leggiStringa("Inserimento eseguito con successo, premi invio per continuare");
					} else {
						risposta = vista.leggiStringa("Inserimento annullato, premi invio per continuare");
					}
					break;
				
				case 2:
					vista.elencoDipendente(repositoryDipendenti);
					risposta = vista.leggiStringa("Premi invio per continuare");
					break;
				
				case 3:
					trovato = false;
					idCerca = vista.leggiIntero("Id da cercare: ");
					
					if(repositoryDipendenti.size() > 0) {
						for(Dipendente dip : repositoryDipendenti) {
							campi = dip.toString().split(";");
							if(Integer.parseInt(campi[0]) == idCerca) {
								vista.schedaDipendente(dip);
								trovato = true;
								risposta = vista.leggiStringa("Premi invio per continuare");
								break;
							}
						}
						if(!trovato) {
							risposta = vista.leggiStringa("Id cercato: " + idCerca + " non trovato! Premi invio per continuare.");
						}

					} else {
						risposta = vista.leggiStringa("Lista vuota. Premi invio per continuare");
					}
					break;
				case 4: //cerca per nome e cognome, se ci sono doppioni cercare per id
					trovato = false;
					nomeCerca = vista.leggiStringa("Nome da cercare: ");
					cognomeCerca = vista.leggiStringa("Cognome da cercare: ");
					dipendentiTrovati = new ArrayList<>();
					
					if(repositoryDipendenti.size() > 0) {
						for(Dipendente dip : repositoryDipendenti) {
							if(dip.getNome().equals(nomeCerca) && dip.getCognome().equals(cognomeCerca)) {
								dipendentiTrovati.add(dip);
							}
						}
						
						if(dipendentiTrovati.size() == 1) {
							vista.schedaDipendente(dipendentiTrovati.get(0));
							trovato = true;
							risposta = vista.leggiStringa("Premi invio per continuare");
						}
						if(dipendentiTrovati.size() > 1) {
							vista.elencoDipendente(dipendentiTrovati);
							idCerca = vista.leggiIntero("Dipendenti multipli trovati, inserire id da cercare: ");
							
							for(Dipendente dip : dipendentiTrovati) {
								if(dip.getId() == idCerca) {
									vista.schedaDipendente(dip);
									trovato = true;
									risposta = vista.leggiStringa("Premi invio per continuare");
									break;
								}
							}
						}
						if(!trovato) {
							risposta = vista.leggiStringa("Dipendente " + nomeCerca + " " + cognomeCerca + " non trovato! Premi invio per continuare.");
						}
						
					} else {
						risposta = vista.leggiStringa("Lista vuota. Premi invio per continuare");
					}

					
					break;
				case 5:
					vista.visualizzaMessaggio("Fine programma.");
					break;
			}
		}
	}

}
