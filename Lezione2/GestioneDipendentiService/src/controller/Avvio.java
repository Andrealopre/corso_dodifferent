package controller;

import java.util.ArrayList;

import model.Dipendente;
import view.Vista;

public class Avvio {

	public static void main(String[] args) {
		ArrayList<Dipendente> dipendentiTrovati = new ArrayList<>();
		Vista vista = new Vista();
		DAOService daoService = new DAOService();
		Dipendente dipendente;
		int sceltaMenu = 0;
		int sceltaSecondaria = 0;
		int idCerca;
		String risposta = "";
		String nomeCerca;
		String cognomeCerca;
		
		while(sceltaMenu != 4) {
			vista.menu();
			sceltaMenu = vista.leggiIntero("Scegli: ");
			
			switch(sceltaMenu) {
				case 1: //inserimento
					dipendente = new Dipendente();
					vista.mascheraInserimento(dipendente);
					risposta = vista.leggiStringa("Confermi l'inserimento (s/n)? ").toLowerCase();
					if(risposta.equals("s")) {
						daoService.inserimento(dipendente);
						risposta = vista.leggiStringa("Inserimento eseguito con successo. Premi invio per continuare.");
					} else {
						risposta = vista.leggiStringa("Inserimento annullato. Premi invio per continuare.");
					}
					break;
				case 2: //visualizza
					vista.elencoDipendente(daoService.getRepositoryDipendente());
					risposta = vista.leggiStringa("Premi invio per continuare.");
					break;
				case 3:
					while(sceltaSecondaria != 3) {
						vista.menuCerca();
						sceltaSecondaria = vista.leggiIntero("Scegli: ");
						switch(sceltaSecondaria) {
							case 1:
								idCerca = vista.leggiIntero("Id da cercare: ");
								dipendente = daoService.cerca(idCerca);
								if(dipendente != null) {
									vista.schedaDipendente(dipendente);
								} else {
									vista.visualizzaMessaggio("Id " + idCerca + " non è stato trovato;");
								}
								risposta = vista.leggiStringa("Premi invio per continuare.");
								break;
							case 2:
								nomeCerca = vista.leggiStringa("Inserisci il nome da cercare: ");
								cognomeCerca = vista.leggiStringa("Inserisci il cognome da cercare: ");
								dipendentiTrovati = daoService.cerca(cognomeCerca, nomeCerca);
								
								if(dipendentiTrovati.size() == 0) {
									vista.visualizzaMessaggio(cognomeCerca + " " + nomeCerca + " non trovati");
								}
								if(dipendentiTrovati.size() == 1) {
									vista.schedaDipendente(dipendentiTrovati.get(0));
								}
								if(dipendentiTrovati.size() > 1) {
									vista.elencoDipendente(dipendentiTrovati);
									idCerca = vista.leggiIntero("Inserisci l'id da cercare: ");
									dipendente = daoService.cerca(idCerca);
									if(dipendente != null) {
										vista.schedaDipendente(dipendente);
									} else {
										vista.visualizzaMessaggio("Id " + idCerca + " non è stato trovato");
									}
									
								}
								risposta = vista.leggiStringa("Premi invio per continuare");
								break;
						}
					}
					break;
				case 4:
					vista.visualizzaMessaggio("Fine programma.");
					break;
			}
		}
	}

}
