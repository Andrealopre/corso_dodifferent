package controller;

import java.util.ArrayList;

import model.Dipendente;
import view.Vista;

public class Avvio {

	public static void main(String[] args) {
		ArrayList<Dipendente> dipendentiTrovati = new ArrayList<>();
		DAOService daoService = new DAOService();
		Validazione validazione = new Validazione(daoService);
		Vista vista = new Vista(validazione);
		Dipendente dipendente;
		int sceltaMenu = 0;
		int sceltaSecondaria = 0;
		int sceltaMenuModifica = 0;
		int idCerca;
		int indice;
		String risposta = "";
		String nomeCerca;
		String cognomeCerca;
		Boolean trovato = false;

		while (sceltaMenu != 4) {
			vista.menu();
			sceltaMenu = vista.leggiIntero("Scegli: ");
			
			

			switch (sceltaMenu) {
			case 1: // inserimento
				dipendente = new Dipendente();
				vista.mascheraInserimento(dipendente);
				risposta = vista.leggiStringa("Confermi l'inserimento (s/n)? ").toLowerCase();
				if (risposta.equals("s")) {
					daoService.inserimento(dipendente);
					risposta = vista.leggiStringa("Inserimento eseguito con successo. Premi invio per continuare.");
					daoService.salva();
				} else {
					risposta = vista.leggiStringa("Inserimento annullato. Premi invio per continuare.");
				}
				break;
			case 2: // visualizza
				vista.elencoDipendente(daoService.getRepositoryDipendente());
				risposta = vista.leggiStringa("Premi invio per continuare.");
				break;
			case 3:
				if(daoService.getRepositoryDipendente().size() == 0) {
					risposta = vista.leggiStringa("Elenco vuoto");
					break;
				}
				trovato = false;
				sceltaSecondaria = 0;
				while (sceltaSecondaria != 3) {
					vista.menuCerca();
					sceltaSecondaria = vista.leggiIntero("Scegli: ");
					switch (sceltaSecondaria) {
					case 1:
						idCerca = vista.leggiIntero("Id da cercare: ");
						dipendente = daoService.cerca(idCerca);
						if (dipendente != null) {
							vista.schedaDipendente(dipendente);
							sceltaMenuModifica = vista.leggiIntero("1-Modifica  2-Cancella  3-Esci  -Scegli > ");
							while (sceltaMenuModifica != 3) {
								switch (sceltaMenuModifica) {
								case 1:
									// Nella modifica non si cambia mai l'id. Si elimina ma non si modifica, solo
									// dal nome in poi.
									indice = daoService.getRepositoryDipendente().indexOf(dipendente);
									dipendente = vista.mascheraModifica(dipendente);
									vista.schedaDipendente(dipendente);
									risposta = vista.leggiStringa("Confermi la modifica? (s/n) ");
									if (risposta.equals("s")) {
										daoService.modifica(indice, dipendente);
										daoService.salva();
										vista.leggiStringa("Dipendente modificato. Premi invio per continuare");
										sceltaMenuModifica = 3;
									} else {
										vista.leggiStringa("Modifica annullata. Premi invio per continuare");
									}
									break;
								case 2:
									risposta = vista.leggiStringa("Confermi la cancellazione? (s/n) ").toLowerCase();
									if (risposta.equals("s")) {
										daoService.cancella(dipendente);
										daoService.salva();
										vista.leggiStringa("Dipendente eliminato. Premi invio per continuare");
										sceltaMenuModifica = 3;
									} else {
										vista.leggiStringa("Cancellazione annullata. Premi invio per continuare");
									}
									break;
								}
								
							}
							
						} else {
							vista.visualizzaMessaggio("Id " + idCerca + " non è stato trovato;");
						}
						risposta = vista.leggiStringa("Premi invio per continuare.");
						break;
					case 2:
						nomeCerca = vista.leggiStringa("Inserisci il nome da cercare: ");
						cognomeCerca = vista.leggiStringa("Inserisci il cognome da cercare: ");
						dipendentiTrovati = daoService.cerca(cognomeCerca, nomeCerca);

						if (dipendentiTrovati.size() == 0) {
							vista.visualizzaMessaggio(cognomeCerca + " " + nomeCerca + " non trovati");
						}
						if (dipendentiTrovati.size() == 1) {
							vista.schedaDipendente(dipendentiTrovati.get(0));
							sceltaMenuModifica = vista.leggiIntero("1-Modifica  2-Cancella  3-Esci  -Scegli > ");
							while (sceltaMenuModifica != 3) {
								
								switch (sceltaMenuModifica) {
								case 1:
									// Nella modifica non si cambia mai l'id. Si elimina ma non si modifica, solo
									// dal nome in poi.
									indice = daoService.getRepositoryDipendente().indexOf(dipendentiTrovati.get(0));
									dipendente = vista.mascheraModifica(dipendentiTrovati.get(0));
									vista.schedaDipendente(dipendente);
									risposta = vista.leggiStringa("Confermi la modifica? (s/n) ");
									if (risposta.equals("s")) {
										daoService.modifica(indice, dipendente);
										daoService.salva();
										vista.leggiStringa("Dipendente modificato. Premi invio per continuare");
										sceltaMenuModifica = 3;
									} else {
										vista.leggiStringa("Modifica annullata. Premi invio per continuare");
									}
									break;
								case 2:
									risposta = vista.leggiStringa("Confermi la cancellazione? (s/n) ").toLowerCase();
									if (risposta.equals("s")) {
										daoService.cancella(dipendentiTrovati.get(0));
										daoService.salva();
										vista.leggiStringa("Dipendente eliminato. Premi invio per continuare");
										sceltaMenuModifica = 3;
									} else {
										vista.leggiStringa("Cancellazione annullata. Premi invio per continuare");
									}
									break;
								}
								
							}
						}
						if (dipendentiTrovati.size() > 1) {
							vista.elencoDipendente(dipendentiTrovati);
							idCerca = vista.leggiIntero("Inserisci l'id da cercare: ");
							for (Dipendente dip : dipendentiTrovati) {
								if (dip.getId() == idCerca) {
									vista.schedaDipendente(dip);
									trovato = true;
									sceltaMenuModifica = vista.leggiIntero("1-Modifica  2-Cancella  3-Esci  -Scegli > ");
									while (sceltaMenuModifica != 3) {
										switch (sceltaMenuModifica) {
										case 1:
											// Nella modifica non si cambia mai l'id. Si elimina ma non si modifica,
											// solo dal nome in poi.
											indice = daoService.getRepositoryDipendente().indexOf(dip);
											dip = vista.mascheraModifica(dip);
											vista.schedaDipendente(dip);
											risposta = vista.leggiStringa("Confermi la modifica? (s/n) ");
											if (risposta.equals("s")) {
												daoService.modifica(indice, dip);
												daoService.salva();
												vista.leggiStringa("Dipendente modificato. Premi invio per continuare");
												sceltaMenuModifica = 3;
											} else {
												vista.leggiStringa("Modifica annullata. Premi invio per continuare");
											}
											break;
										case 2:
											risposta = vista.leggiStringa("Confermi la cancellazione? (s/n) ")
													.toLowerCase();
											if (risposta.equals("s")) {
												daoService.cancella(dip);
												daoService.salva();
												vista.leggiStringa("Dipendente eliminato. Premi invio per continuare");
												sceltaMenuModifica = 3;
											} else {
												vista.leggiStringa(
														"Cancellazione annullata. Premi invio per continuare");
											}
											break;
										}
									}
									break;
								}
							}
							if (!trovato) {
								vista.visualizzaMessaggio("Id " + idCerca + " non è stato trovato");
							}
						}
						risposta = vista.leggiStringa("Premi invio per continuare");
						break;
					}
				}
				break;
			case 4:
				if (daoService.salva()) {
					vista.visualizzaMessaggio("Salvataggio avvenuto");
				} else {
					vista.visualizzaMessaggio("Errore di salvataggio");
				}
				vista.visualizzaMessaggio("Fine programma.");
				break;
			}
		}
	}
}
