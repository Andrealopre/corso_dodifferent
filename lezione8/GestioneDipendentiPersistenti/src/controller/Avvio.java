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
		int scelta = 0;
		int sceltaDipendente = 0;
		int sceltaModifica = 0;
		String confermaScelta = "";
		String risposta = "";
		
		while(scelta != 6) {
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
			case 2:
				vista.visualizzaMessaggio("*** Lista Dipendenti ***");
				repoDipendenti = crud.leggiDipendenti();
				if(repoDipendenti != null) {
					for(Dipendente dip : repoDipendenti) {
						vista.visualizzaMessaggio(dip.toString());
						vista.visualizzaMessaggio("");
					}
				} else {
					vista.visualizzaMessaggio("Repo vuota");
				}
				risposta = vista.leggiStringa("Premi invio per continuare");
				break;
			case 3:
				vista.visualizzaMessaggio("*** Eliminazione dipendenti ***");
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
				dipendente.getNome() + " " + dipendente.getCognome() + " (s/n)?");
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
			case 4:
				vista.visualizzaMessaggio("*** Modifica Dipendenti ***");
				vista.visualizzaMessaggio("Dipendenti disponibili");
				repoDipendenti = crud.leggiDipendenti();
				
				if(repoDipendenti != null) {
					for(Dipendente dip : repoDipendenti) {
						vista.visualizzaMessaggio(dip.toString());
						vista.visualizzaMessaggio("");
					}
					vista.visualizzaMessaggio("");
				} else {
					vista.visualizzaMessaggio("Repo vuota");
					break;
				}
				vista.visualizzaMessaggio("");
				sceltaDipendente = vista.leggiIntero("Inserisci id del dipendente da modificare: ");
				dipendente = crud.leggiDipendente(sceltaDipendente);
				vista.visualizzaMessaggio("Dipendente selezionato");
				vista.visualizzaMessaggio(dipendente.toString());
				vista.visualizzaMessaggio("");
				vista.visualizzaMessaggio("1. Nome");
				vista.visualizzaMessaggio("2. Cognome");
				vista.visualizzaMessaggio("3. Sesso");
				vista.visualizzaMessaggio("4. Stipendio");
				vista.visualizzaMessaggio("5. Codice Fiscale");
				sceltaModifica = vista.leggiIntero("Scegli il campo da modificare: ");
				switch(sceltaModifica) {
				case 1:
					String nome = "";
					vista.visualizzaMessaggio("Schermata modifica nome");
					nome = vista.leggiStringa("Inserisci il nuovo nome: ");
					if(crud.modificaStringa(dipendente.getId(), "nome", nome)) {
						vista.visualizzaMessaggio("Modifica avvenuta con successo");
					} else {
						vista.visualizzaMessaggio("Modifica fallita");
						break;
					}
					break;
				case 2:
					String cognome = "";
					vista.visualizzaMessaggio("Schermata modifica cognome");
					cognome = vista.leggiStringa("Inserisci il nuovo cognome: ");
					if(crud.modificaStringa(dipendente.getId(), "cognome", cognome)) {
						vista.visualizzaMessaggio("Modifica avvenuta con successo");
					} else {
						vista.visualizzaMessaggio("Modifica fallita");
						break;
					}
					break;
				case 3:
					String sesso = "";
					vista.visualizzaMessaggio("Schermata modifica sesso");
					nome = vista.leggiStringa("Inserisci il nuovo sesso: ");
					if(crud.modificaStringa(dipendente.getId(), "sesso", sesso)) {
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
					if(crud.modificaNumero(dipendente.getId(), "stipendio", stipendio)) {
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
					if(crud.modificaStringa(dipendente.getId(), "codice_fiscale", codiceFiscale)) {
						vista.visualizzaMessaggio("Modifica avvenuta con successo");
					} else {
						vista.visualizzaMessaggio("Modifica fallita");
						break;
					}
					break;
				}
				break;
			case 5:
				vista.visualizzaMessaggio("*** Cerca dipendente per id ***");
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
			case 6:
				vista.visualizzaMessaggio("Terminazione programma");
				risposta = vista.leggiStringa("Premi invio per chiudere");
				break;
			}
		}
	}
}
