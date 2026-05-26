package controller;

import java.util.List;

import model.*;
import repository.*;
import view.Vista;

public class Avvio {

	public static void main(String[] args) {
		List<Dipendente> repoDipendenti;
		Vista vista = new Vista();
		ICrudService crud = new CrudService();
		int scelta = 0;
		String risposta;
		
		
		while(scelta != 4) {
			vista.menu();
			scelta = vista.leggiIntero("Scegli cosa fare: ");
			switch(scelta) {
			case 1:
				Dipendente dipendente;
				dipendente = vista.mascheraDipendente(crud);
				if(crud.inserisciDipendente(dipendente)) {
					vista.visualizzaMessaggio("Inserimento dipendente riuscito!");
					risposta = vista.leggiStringa("Premi invio per continuare");
				} else {
					vista.visualizzaMessaggio("Inserimento fallito");
				}
				break;
			case 2:
				repoDipendenti = crud.leggiDipendenti();
				if(repoDipendenti != null) {
					for(Dipendente dip : repoDipendenti) {
						vista.visualizzaMessaggio(dip.toString());
					}
				} else {
					vista.visualizzaMessaggio("Repo vuota");
				}
				vista.visualizzaMessaggio("");
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}
	}

}
