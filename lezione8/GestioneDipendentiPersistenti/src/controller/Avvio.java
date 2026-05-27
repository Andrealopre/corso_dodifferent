package controller;

import java.util.List;

import model.*;
import repository.*;
import view.Vista;

public class Avvio {

	public static void main(String[] args) {
		Dipendente dipendente = null;
		Account account = null;
		RuoloAziendale ruoloAziendale = null;
		Vista vista = new Vista();
		List<Dipendente> repoDipendenti;
		ICrudService crud = new CrudService();
		List<RuoloAziendale> listRuoliAziendali = null;
		List<Account> listAccount = null;
		int scelta = 0;
		int sceltaMenu = 0;
		int sceltaDipendente = 0;
		int sceltaAccount = 0;
		int sceltaModifica = 0;
		String confermaScelta = "";
		String risposta = "";
		String nome = "";
		String cognome = "";
		String username = "";
		String password = "";
		
		while(scelta != 5) {
			scelta = 0;
			listRuoliAziendali = crud.leggiRuoliAziendali();
			vista.menu();
			scelta = vista.leggiIntero("Scegli cosa fare: ");
			switch(scelta) {
			case 1:
				account = vista.mascheraAccount();
				ruoloAziendale = vista.mascheraRuoloAziendale(listRuoliAziendali);
				dipendente = vista.mascheraDipendente(account, ruoloAziendale);
				if(crud.inserisciAccount(account)) {
					vista.visualizzaMessaggio("Inserimento account riuscito!");
				} else {
					vista.visualizzaMessaggio("Inserimento fallito");
				}
				if(crud.inserisciDipendente(dipendente)) {
					vista.visualizzaMessaggio("Inserimento dipendente riuscito!");
					risposta = vista.leggiStringa("Premi invio per continuare");
				} else {
					vista.visualizzaMessaggio("Inserimento fallito");
				}
				risposta = vista.leggiStringa("Premi invio per continuare");
				vista.visualizzaMessaggio("");
				break;
			case 2: //menu dipendente
				sceltaMenu = 0;
				while(sceltaMenu != 6) {
					vista.menuDipendente();
					sceltaMenu = vista.leggiIntero("Inserisci la scelta: ");
					vista.visualizzaMessaggio("");
					switch(sceltaMenu) {
					case 1:
						repoDipendenti = crud.leggiDipendenti();
						if(repoDipendenti != null) {
							vista.visualizzaMessaggio("----------------------------------");
							for(Dipendente dip : repoDipendenti) {
								vista.visualizzaMessaggio(dip.toString());
								vista.visualizzaMessaggio("");
								vista.visualizzaMessaggio("----------------------------------");
							}
						} else {
							vista.visualizzaMessaggio("Repo vuota");
						}
						risposta = vista.leggiStringa("Premi invio per continuare");
						break;
					case 2:
						sceltaDipendente = vista.leggiIntero("Scegli l'id da cercare: ");
						dipendente = crud.leggiDipendente(sceltaDipendente);
						if(dipendente != null) {
							vista.visualizzaMessaggio("");
							vista.visualizzaMessaggio("Dipendente cercato: ");
							vista.visualizzaMessaggio(dipendente.toString());
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						} else {
							vista.visualizzaMessaggio("");
							vista.visualizzaMessaggio("Dipendente non trovato");
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						}
						break;
					case 3:
						nome = vista.leggiStringa("Inserisci il nome: ");
						cognome = vista.leggiStringa("Inserisci il cognome: ");
						dipendente = crud.leggiDipendente(nome, cognome);
						if(dipendente != null) {
							vista.visualizzaMessaggio("");
							vista.visualizzaMessaggio("Dipendente cercato:");
							vista.visualizzaMessaggio(dipendente.toString());
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						} else {
							vista.visualizzaMessaggio("");
							vista.visualizzaMessaggio("Dipendente non trovato");
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						}
						break;
					case 4:
						//rimozione dipendente
						vista.visualizzaMessaggio("Dipendenti disponibili");
						repoDipendenti = crud.leggiDipendenti();
						if(repoDipendenti != null) {
							for(Dipendente dip : repoDipendenti) {
								vista.visualizzaMessaggio(dip.toString());
								vista.visualizzaMessaggio("");
							}
						} else {
							vista.visualizzaMessaggio("Repo vuota");
							break;
						}
						sceltaDipendente = vista.leggiIntero("Inserisci id del dipendente da eliminare: ");
						dipendente = crud.leggiDipendente(sceltaDipendente);
						vista.visualizzaMessaggio("");
						vista.visualizzaMessaggio("Dipendente selezionato:");
						vista.visualizzaMessaggio(dipendente.toString());
						confermaScelta = vista.leggiStringa("Confermi di voler eliminare il dipendente " + 
						dipendente.getNome() + " " + dipendente.getCognome() + " (s/n)? ");
						if(confermaScelta.toLowerCase().equals("s")) {
							if(crud.rimuovi(dipendente.getId())) {
								vista.visualizzaMessaggio("Rimozione effettuata!");
								risposta = vista.leggiStringa("Premi invio per continuare");
								vista.visualizzaMessaggio("");
							} else {
								vista.visualizzaMessaggio("Rimozione fallita");
								risposta = vista.leggiStringa("Premi invio per continuare");
								vista.visualizzaMessaggio("");
							}
						} 
						else if(confermaScelta.toLowerCase().equals("n")) {
							vista.visualizzaMessaggio("Eliminazione annullata");
							risposta = vista.leggiStringa("Premi invio per continuare");
						}
						break;
					case 5:
						//modifica dipendenti
						sceltaModifica = 0;
						vista.visualizzaMessaggio("Dipendenti disponibili");
						repoDipendenti = crud.leggiDipendenti();
						
						if(repoDipendenti != null) {
							for(Dipendente dip : repoDipendenti) {
								vista.visualizzaMessaggio(dip.toString());
								vista.visualizzaMessaggio("");
							}
							vista.visualizzaMessaggio("");
							sceltaDipendente = vista.leggiIntero("Inserisci id del dipendente da modificare: ");
							dipendente = crud.leggiDipendente(sceltaDipendente);
							while(sceltaModifica != 7) {
								vista.visualizzaMessaggio("Dipendente selezionato");
								vista.visualizzaMessaggio(dipendente.toString());
								vista.visualizzaMessaggio("");
								vista.visualizzaMessaggio("1. Nome");
								vista.visualizzaMessaggio("2. Cognome");
								vista.visualizzaMessaggio("3. Sesso");
								vista.visualizzaMessaggio("4. Stipendio");
								vista.visualizzaMessaggio("5. Codice Fiscale");
								vista.visualizzaMessaggio("6. Ruolo Aziendale");
								vista.visualizzaMessaggio("7. Esci");
								
								sceltaModifica = vista.leggiIntero("Scegli il campo da modificare: ");
								switch(sceltaModifica) {
								case 1:
									vista.visualizzaMessaggio("Schermata modifica nome");
									nome = vista.leggiStringa("Inserisci il nuovo nome: ");
									if(crud.modificaStringa(dipendente.getId(), "dipendenti", "nome", nome)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										break;
									}
									break;
								case 2:
									vista.visualizzaMessaggio("Schermata modifica cognome");
									cognome = vista.leggiStringa("Inserisci il nuovo cognome: ");
									if(crud.modificaStringa(dipendente.getId(), "dipendenti", "cognome", cognome)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										break;
									}
									break;
								case 3:
									String sesso = "";
									vista.visualizzaMessaggio("Schermata modifica sesso");
									sesso = vista.leggiStringa("Inserisci il nuovo sesso: ");
									if(crud.modificaStringa(dipendente.getId(), "dipendenti", "sesso", sesso)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										break;
									}
									break;
								case 4:
									Double stipendio = 0.0;
									vista.visualizzaMessaggio("Schermata modifica stipendio");
									stipendio = vista.leggiDecimale("Inserisci il nuovo stipendio: ");
									if(crud.modificaDecimale(dipendente.getId(), "dipendenti", "stipendio", stipendio)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										break;
									}
									break;
								case 5:
									String codiceFiscale = "";
									vista.visualizzaMessaggio("Schermata modifica codice fiscale");
									codiceFiscale = vista.leggiStringa("Inserisci il nuovo codice fiscale: ");
									if(crud.modificaStringa(dipendente.getId(), "dipendenti", "codice_fiscale", codiceFiscale)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										break;
									}
									break;
								case 6:
									int ruoloScelto = 0;
									vista.visualizzaMessaggio("Schermata modifica ruolo aziendale");
									vista.visualizzaMessaggio("Ruoli disponibili:");
									for(RuoloAziendale ruolo : listRuoliAziendali) {
										vista.visualizzaMessaggio(ruolo.toString());
									}
									vista.visualizzaMessaggio("");
									ruoloScelto = vista.leggiIntero("Inserisci il nuovo ruolo aziendale: ");
									if(crud.modificaIntero(dipendente.getId(), "dipendenti", "id_ruolo_aziendale", ruoloScelto)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										break;
									}
									break;
								}
							}
						} else {
							vista.visualizzaMessaggio("Repo vuota");
							break;
						}
						break;
					case 6:
						risposta = vista.leggiStringa("Premi invio per continuare");
						break;
					}
				}
				break;
			case 3: //menu account
				sceltaMenu = 0;
				while(sceltaMenu != 5) {
					vista.menuAccount();
					sceltaMenu = vista.leggiIntero("Scegli cosa fare: ");
					switch(sceltaMenu) {
					case 1: //lista degli account
						listAccount = crud.leggiAccount();
						vista.visualizzaMessaggio("Account esistenti:");
						vista.visualizzaMessaggio("");
						vista.visualizzaMessaggio("----------------------------------");
						if(listAccount != null) {
							for(Account acc : listAccount) {
								vista.visualizzaMessaggio(acc.toString());
								vista.visualizzaMessaggio("----------------------------------");
							}
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						} else {
							vista.visualizzaMessaggio("Nessun account disponibile");
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						}
						break;
					case 2: //ricerca per id account
						sceltaAccount = vista.leggiIntero("Scegli l'id da cercare: ");
						account = crud.leggiAccount(sceltaAccount);
						if(account != null) {
							vista.visualizzaMessaggio("");
							vista.visualizzaMessaggio("Account cercato: ");
							vista.visualizzaMessaggio(account.toString());
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						} else {
							vista.visualizzaMessaggio("");
							vista.visualizzaMessaggio("Account non trovato");
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						}
						break;
					case 3: //ricerca account per username
						vista.visualizzaMessaggio("");
						username = vista.leggiStringa("Inserisci lo username da cercare: ");
						account = crud.leggiAccount(username);
						if(account != null) {
							vista.visualizzaMessaggio("");
							vista.visualizzaMessaggio("Account cercato:");
							vista.visualizzaMessaggio(account.toString());
							risposta = vista.leggiStringa("Premi invio per continuare");
							vista.visualizzaMessaggio("");
						}
						break;
					case 4: //modifica account
						sceltaModifica = 0;
						vista.visualizzaMessaggio("");
						vista.visualizzaMessaggio("Account disponibili:");
						listAccount = crud.leggiAccount();
						if(listAccount != null) {
							for(Account acc : listAccount) {
								vista.visualizzaMessaggio(acc.toString());
							}
							vista.visualizzaMessaggio("");
							sceltaAccount = vista.leggiIntero("Inserisci l'id dell'account da modificare");
							account = crud.leggiAccount(sceltaAccount);
							while(sceltaModifica != 3) {
								vista.menuModificaAccount();
								sceltaModifica = vista.leggiIntero("Scegli cosa fare: ");
								switch(sceltaModifica) {
								case 1:
									vista.visualizzaMessaggio("");
									username = vista.leggiStringa("Inserisci il nuovo username");
									if(crud.modificaStringa(account.getId_account(), "account", "nome_utente", username)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo!");
										risposta = vista.leggiStringa("Premi invio per continuare");
										vista.visualizzaMessaggio("");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										risposta = vista.leggiStringa("Premi invio per continuare");
										vista.visualizzaMessaggio("");
									}
									break;
								case 2:
									vista.visualizzaMessaggio("");
									password = vista.leggiStringa("Inserisci la nuova password");
									if(crud.modificaStringa(account.getId_account(), "account", "password", password)) {
										vista.visualizzaMessaggio("Modifica avvenuta con successo!");
										risposta = vista.leggiStringa("Premi invio per continuare");
										vista.visualizzaMessaggio("");
									} else {
										vista.visualizzaMessaggio("Modifica fallita");
										risposta = vista.leggiStringa("Premi invio per continuare");
										vista.visualizzaMessaggio("");
									}
									break;
								case 3:
									risposta = vista.leggiStringa("Premi invio per continuare");
									break;
								}
							}
						} else {
							vista.visualizzaMessaggio("Non sono presenti account");
						}
						break;
					case 5:
						risposta = vista.leggiStringa("Premi invio per continuare");
						break;
					}
				}
				break;
			case 5:
				vista.visualizzaMessaggio("Terminazione programma");
				risposta = vista.leggiStringa("Premi invio per chiudere");
				break;
			}
		}
	}
}
