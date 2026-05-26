package view;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.*;
import repository.ICrudService;


public class Vista {
	public void menu() {
		// Vista del menu che verrà utilizzato. Ogni metodo si può immaginare con una
		// pagina html
		// nextInt() non legge l'invio, usare nextLine() e poi parseInt()
		System.out.println("*** MENU PRINCIPALE ***");
		System.out.println("1) Inserisci un utente");
		System.out.println("2) Visualizza gli utenti");
		System.out.println("3) Rimuovi");
		System.out.println("4) Esci");
	}
	
	public int leggiIntero(String messaggio) {
		Scanner in = new Scanner(System.in);
		int valore = 0;
		System.out.print(messaggio);
		valore = Integer.parseInt(in.nextLine());
		return valore;
	}
	
	public String leggiStringa(String messaggio) {
		Scanner in = new Scanner(System.in);
		String valore = "";
		System.out.print(messaggio);
		valore = in.nextLine();
		return valore;
	}

	public double leggiDecimale(String messaggio) {
		Scanner in = new Scanner(System.in);
		double valore = 0;
		System.out.print(messaggio);
		valore = Double.parseDouble(in.nextLine());
		return valore;
	}
	
	public void visualizzaMessaggio(String messaggio) {
		System.out.println(messaggio);
	}
	
	public Dipendente mascheraDipendente(ICrudService crud) {
		String valore;
		int scelta;
		Double stipendio;
		Date data;
		List<RuoloAziendale> listRuoliAziendali = crud.leggiRuoliAziendali();
		Account account = new Account();
		RuoloAziendale ruoloAziendale = new RuoloAziendale();
		Dipendente dipendente = new Dipendente();
		
		System.out.println("--------------------------------------------");
		System.out.println("*** Schermata di inserimento Dipendente ***");
		System.out.println("Inserimento account");
		valore = leggiStringa("Inserisci il nome utente: ");
		account.setNomeUtente(valore);
		valore = leggiStringa("Inserisci la password: ");
		account.setPassword(valore);
		System.out.println();
		if(crud.inserisciAccount(account)) {
			visualizzaMessaggio("Inserimento account riuscito!");
		} else {
			visualizzaMessaggio("Inserimento fallito");
		}
		
		account = crud.leggiAccount(account);
		
		System.out.println("Inserimento dipendente");
		valore = leggiStringa("Inserisci il nome: ");
		dipendente.setNome(valore);
		valore = leggiStringa("Inserisci il cognome: ");
		dipendente.setCognome(valore);
		valore = leggiStringa("Inserisci il luogo di nascita: ");
		dipendente.setLuogoDiNascista(valore);
		valore = leggiStringa("Inserisci la data di nascita (yyyy-mm-dd): ");
		data = Date.valueOf(valore);
		dipendente.setDataDiNascita(data);
		valore = leggiStringa("Inserisci il codice fiscale: ");
		dipendente.setCodiceFiscale(valore);
		valore = leggiStringa("Inserisci il sesso: ");
		dipendente.setSesso(valore);
		stipendio = leggiDecimale("Inserisci lo stipendio: ");
		dipendente.setStipendio(stipendio);
		dipendente.setAccount(account);
		
		System.out.println("Ruoli aziendali disponibili:");
		for(RuoloAziendale ruolo : listRuoliAziendali) {
			this.visualizzaMessaggio(ruolo.toString()); 
		}
		
		scelta = leggiIntero("Scegli il ruolo: ");
		ruoloAziendale = listRuoliAziendali.get(scelta - 1);
		dipendente.setRuoloAziendale(ruoloAziendale);
		System.out.println("--------------------------------------------");
		return dipendente;
	}
}
