package controller;

import java.util.ArrayList;

import model.Dipendente;
import view.Vista;

public class Avvio {

	public static void main(String[] args) {
		int scelta = 0;
		int idCerca;
		int indice;
		String nomeCerca, cognomeCerca;
		Boolean trovato = false;
		String[] campi;
		ArrayList<Dipendente> dipendentiTrovati;
		ArrayList<Dipendente> repositoryDipendenti = new ArrayList<>();
		Vista vista = new Vista();
		Dipendente dipendente;
		
		while(scelta != 4) {
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
					int sceltaCerca = 0;
					
					while(sceltaCerca != 3) {
						vista.menuCerca();
						sceltaCerca = vista.leggiIntero("Scegli: ");
						
						switch(sceltaCerca) {
							case 1:
								trovato = false;
								idCerca = vista.leggiIntero("Id da cercare: ");
								
								if(repositoryDipendenti.size() > 0) {
									for(Dipendente dip : repositoryDipendenti) {
										campi = dip.toString().split(";");
										if(Integer.parseInt(campi[0]) == idCerca) {
											vista.schedaDipendente(dip);
											trovato = true;
											//vista.menuAggiornamento();
											sceltaCerca = vista.leggiIntero("1-Modifica  2-Cancella  3-Esci  -Scegli > ");
											switch(sceltaCerca) {
												case 1:
													//Nella modifica non si cambia mai l'id. Si elimina ma non si modifica, solo dal nome in poi.
													indice = repositoryDipendenti.indexOf(dip);
													dip = vista.mascheraModifica(dip);
													vista.schedaDipendente(dip);
													risposta = vista.leggiStringa("Confermi la modifica? (s/n) ");
													if(risposta.equals("s")) {
														repositoryDipendenti.set(indice, dip);
														vista.leggiStringa("Dipendente modificato. Premi invio per continuare");
													} else {
														vista.leggiStringa("Modifica annullata. Premi invio per continuare");
													}
													break;
												case 2:
													risposta = vista.leggiStringa("Confermi la cancellazione? (s/n) ").toLowerCase();
													if(risposta.equals("s")) {
														repositoryDipendenti.remove(dip);
														vista.leggiStringa("Dipendente eliminato. Premi invio per continuare");
													} else {
														vista.leggiStringa("Cancellazione annullata. Premi invio per continuare");
													}
													break;
											}
											//risposta = vista.leggiStringa("Premi invio per continuare");
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
							case 2:
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
										sceltaCerca = vista.leggiIntero("1-Modifica  2-Cancella  3-Esci  -Scegli > ");
										switch(sceltaCerca) {
											case 1:
												Dipendente dip = new Dipendente(dipendentiTrovati.get(0));
												indice = repositoryDipendenti.indexOf(dipendentiTrovati.get(0));
												dip = vista.mascheraModifica(dip);
												vista.schedaDipendente(dip);
												risposta = vista.leggiStringa("Confermi la modifica? (s/n) ");
												if(risposta.equals("s")) {
													repositoryDipendenti.set(indice, dip);
													vista.leggiStringa("Dipendente modificato. Premi invio per continuare");
												} else {
													vista.leggiStringa("Modifica annullata. Premi invio per continuare");
												}
												break;
											case 2:
												risposta = vista.leggiStringa("Confermi la cancellazione? (s/n) ").toLowerCase();
												if(risposta.equals("s")) {
													repositoryDipendenti.remove(dipendentiTrovati.get(0));
													vista.leggiStringa("Dipendente eliminato. Premi invio per continuare");
												} else {
													vista.leggiStringa("Cancellazione annullata. Premi invio per continuare");
												}
												break;
										}
										trovato = true;
										//risposta = vista.leggiStringa("Premi invio per continuare");
									}
									if(dipendentiTrovati.size() > 1) {
										vista.elencoDipendente(dipendentiTrovati);
										idCerca = vista.leggiIntero("Dipendenti multipli trovati, inserire id da cercare: ");
										
										for(Dipendente dip : dipendentiTrovati) {
											if(dip.getId() == idCerca) {
												vista.schedaDipendente(dip);
												sceltaCerca = vista.leggiIntero("1-Modifica  2-Cancella  3-Esci  -Scegli > ");
												switch(sceltaCerca) {
													case 1:
														indice = repositoryDipendenti.indexOf(dip);
														dip = vista.mascheraModifica(dip);
														vista.schedaDipendente(dip);
														risposta = vista.leggiStringa("Confermi la modifica? (s/n) ");
														if(risposta.equals("s")) {
															repositoryDipendenti.set(indice, dip);
															vista.leggiStringa("Dipendente modificato. Premi invio per continuare");
														} else {
															vista.leggiStringa("Modifica annullata. Premi invio per continuare");
														}
														break;
													case 2:
														risposta = vista.leggiStringa("Confermi la cancellazione? (s/n) ").toLowerCase();
														if(risposta.equals("s")) {
															repositoryDipendenti.remove(dip);
															vista.leggiStringa("Dipendente eliminato. Premi invio per continuare");
														} else {
															vista.leggiStringa("Cancellazione annullata. Premi invio per continuare");
														}
														break;
												}
												trovato = true;
												//risposta = vista.leggiStringa("Premi invio per continuare");
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
