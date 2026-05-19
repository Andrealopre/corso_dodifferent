package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
import java.text.SimpleDateFormat;

import model.Dipendente;

public class Vista {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public void menu() {
		//Vista del menu che verrà utilizzato. Ogni metodo si può immaginare con una pagina html
		//nextInt() non legge l'invio, usare nextLine() e poi parseInt()
		System.out.println("*** MENU PRINCIPALE ***");
		System.out.println("1) Inserimento");
		System.out.println("2) Visualizza");
		System.out.println("3) Cerca");
		System.out.println("4) Esci");
	}
	
	public void menuCerca() {
		System.out.println("*** MENU CERCA ***");
		System.out.println("1) Cerca per Id");
		System.out.println("2) Cerca per cognome e nome");
		System.out.println("3) Esci");
	}
	
	public void menuAggiornamento() {
		System.out.println("1-Modifica  2-Cancella  3-Esci  -Scegli >");
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
	
	public Date leggiData(String messaggio) {
		//Formato USA aaaa-mm-dd
		Scanner in = new Scanner(System.in);
		String stringa = "";
		System.out.println(messaggio);
		stringa = in.nextLine();
		return Date.valueOf(stringa);
	}
	
	public void visualizzaMessaggio(String messaggio) {
		System.out.println(messaggio);
	}
	
	public void elencoDipendente(ArrayList<Dipendente> repositoryDipendenti) {
		String[] campi;
		String riga;
		int i;
		
		if(repositoryDipendenti.size() > 0) {
			for(Dipendente dipendente : repositoryDipendenti) {
				riga = "";
				campi = dipendente.toString().split(";");
				for(i = 0; i < campi.length - 1; i++) {
					if(i == 4) {
						campi[i] = sdf.format(Date.valueOf(campi[i]));
					}
					riga += campi[i] + ", ";
				}
				riga += campi[i];
				this.visualizzaMessaggio(riga);
			}

		} else {
			System.out.println("Elenco vuoto");
		}
		//this.leggiStringa("Premi invio per continuare");
	}
	
	public Dipendente mascheraModifica(Dipendente dipendente) {
		Dipendente dipCopy = new Dipendente(dipendente);
		String appValore = "";
		Date data;
		
		System.out.println("*** Modifica dipendente ***");
		appValore = leggiStringa("Nome[" + dipCopy.getNome() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setNome(appValore);
		}
		appValore = leggiStringa("Cognome[" + dipCopy.getCognome() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setCognome(appValore);
		}
		appValore = leggiStringa("Luogo di nascita[" + dipCopy.getLuogoDiNascita() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setLuogoDiNascita(appValore);
		}
		appValore = leggiStringa("Data di nascita[" + dipCopy.getDataDiNascita() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setDataDiNascita(Date.valueOf(appValore));
		}
		appValore = leggiStringa("Sesso[" + dipCopy.getSesso() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setSesso(appValore);
		}
		appValore = leggiStringa("Codice Fiscale[" + dipCopy.getCodiceFiscale() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setCodiceFiscale(appValore);
		}
		appValore = leggiStringa("Titolo di studio[" + dipCopy.getTitoloDiStudio() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setTitoloDiStudio(appValore);
		}
		appValore = leggiStringa("Ruolo aziendale[" + dipCopy.getRuoloAziendale() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setRuoloAziendale(appValore);
		}
		appValore = leggiStringa("Stipendio[" + dipCopy.getStipendio() + "]: ");
		if(!appValore.equals("")) {
			dipCopy.setStipendio(Double.parseDouble(appValore));
		}
		
		return dipCopy;
	}
	
	public void mascheraInserimento(Dipendente dipendente) {
		System.out.println("*** Inserimento dipendente ***");
		dipendente.setId(this.leggiIntero("ID: "));
		dipendente.setNome(this.leggiStringa("Nome: "));
		dipendente.setCognome(this.leggiStringa("Cognome: "));
		dipendente.setLuogoDiNascita(this.leggiStringa("Luogo di nascita: "));
		dipendente.setDataDiNascita(this.leggiData("Data di nascita: "));
		dipendente.setSesso(this.leggiStringa("Sesso: "));
		dipendente.setCodiceFiscale(this.leggiStringa("Codice fiscale: "));
		dipendente.setTitoloDiStudio(this.leggiStringa("Titolo di studio: "));
		dipendente.setRuoloAziendale(this.leggiStringa("Ruolo aziendale: "));
		dipendente.setStipendio(this.leggiDecimale("Stipendio: "));
	}
	
	public void schedaDipendente(Dipendente dipendente) {
		System.out.println("*** Scheda dipendente ***");
		System.out.println("ID: " + dipendente.getId());
		System.out.println("Nome: " + dipendente.getNome());
		System.out.println("Cognome: " + dipendente.getCognome());
		System.out.println("Luogo di nascita: " + dipendente.getLuogoDiNascita());
		System.out.println("Data di nascita: " + dipendente.getDataDiNascita());
		System.out.println("Sesso: " + dipendente.getSesso());
		System.out.println("Codice fiscale: " + dipendente.getCodiceFiscale());
		System.out.println("Titolo di studio" + dipendente.getTitoloDiStudio());
		System.out.println("Ruolo aziendale: " + dipendente.getRuoloAziendale());
		System.out.println("Stipendio " + dipendente.getStipendio());
	}
}
