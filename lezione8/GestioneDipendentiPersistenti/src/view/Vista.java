package view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.*;


public class Vista {
	public void menu() {
		// Vista del menu che verrà utilizzato. Ogni metodo si può immaginare con una
		// pagina html
		// nextInt() non legge l'invio, usare nextLine() e poi parseInt()
		System.out.println("*** MENU PRINCIPALE ***");
		System.out.println("1) Inserisci un dipendente");
		System.out.println("2) Visualizza i dipendenti");
		System.out.println("3) Rimuovi Dipendente");
		System.out.println("4) Modifica Dipendente");
		System.out.println("5) Cerca dipendente per id");
		System.out.println("6) Esci");
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
	
	public Account mascheraAccount() {
		Account account = new Account();
		String valore = "";

		System.out.println("--------------------------------------------");
		System.out.println("*** Schermata di inserimento Account ***");
		System.out.println("Inserimento account");
		valore = leggiStringa("Inserisci il nome utente: ");
		account.setNomeUtente(valore);
		valore = leggiStringa("Inserisci la password: ");
		account.setPassword(valore);
		System.out.println();
		return account;
	}
	
	public RuoloAziendale mascheraRuoloAziendale(List<RuoloAziendale> listRuoliAziendali) {
		RuoloAziendale ruoloAziendale;
		int scelta = 0;

		System.out.println("Ruoli aziendali disponibili:");
		for(RuoloAziendale ruolo : listRuoliAziendali) {
			this.visualizzaMessaggio(ruolo.toString()); 
		}
		scelta = leggiIntero("Scegli il ruolo: ");
		ruoloAziendale = listRuoliAziendali.get(scelta - 1);
		return ruoloAziendale;
	}
	
	public Dipendente mascheraDipendente(Account account, RuoloAziendale ruoloAziendale) {
		String valore = "";
		Double stipendio = 0.0;
		Date data;
		Dipendente dipendente = new Dipendente();
		
		System.out.println("--------------------------------------------");
		System.out.println("*** Schermata di inserimento Dipendente ***");
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
		dipendente.setRuoloAziendale(ruoloAziendale);
		System.out.println("--------------------------------------------");
		return dipendente;
	}
}
