package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.DAOService;
import controller.Validazione;

import java.sql.Date;
import java.text.SimpleDateFormat;

import model.Dipendente;

public class Vista {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Validazione validazione;

	public void menu() {
		// Vista del menu che verrà utilizzato. Ogni metodo si può immaginare con una
		// pagina html
		// nextInt() non legge l'invio, usare nextLine() e poi parseInt()
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
		// Formato USA aaaa-mm-dd
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

		if (repositoryDipendenti.size() > 0) {
			for (Dipendente dipendente : repositoryDipendenti) {
				riga = "";
				campi = dipendente.toString().split(";");
				for (i = 0; i < campi.length - 1; i++) {
					if (i == 4) {
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
		// this.leggiStringa("Premi invio per continuare");
	}

	public Dipendente mascheraModifica(Dipendente dipendente) {
		Dipendente dipCopy = new Dipendente(dipendente);
		String appValore = "";

		System.out.println("*** Modifica dipendente ***");
		do {
			appValore = leggiStringa("Nome[" + dipCopy.getNome() + "]: ");
			if (!appValore.equals("")) {
				if (validazione.contieneNumeri(appValore)) {
					System.out.println("ERRORE: nome non valido");
					continue;
				}
				dipCopy.setNome(appValore);
			}
			break;
		} while (true);

		do {
			appValore = leggiStringa("Cognome[" + dipCopy.getCognome() + "]: ");
			if (!appValore.equals("")) {
				if (validazione.contieneNumeri(appValore)) {
					System.out.println("ERRORE: cognome non valido");
					continue;
				}
				dipCopy.setCognome(appValore);
			}
			break;
		} while (true);
		
		do {
			appValore = leggiStringa("Luogo di nascita[" + dipCopy.getLuogoDiNascita() + "]: ");
			if (!appValore.equals("")) {
				if(validazione.contieneNumeri(appValore)) {
					System.out.println("ERRORE: luogo di nascita non valido");
					continue;
				}
				dipCopy.setLuogoDiNascita(appValore);
			}
			break;
		} while(true);
		
		
		Date dataNascita;
		do {
			appValore = leggiStringa("Inserisci data nascita (yyyy-MM-dd): ");
			if (!appValore.equals("")) {
				if (!validazione.dataValida(appValore)) {
					System.out.println("ERRORE: formato data non valido");
					continue;
				}
				try {
					dataNascita = Date.valueOf(appValore);
					dipCopy.setDataDiNascita(dataNascita);
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("ERRORE: data inesistente");
				}
				
			}
			break;
		} while (true);
		
		do {
			appValore = leggiStringa("Sesso[" + dipCopy.getSesso() + "]: ");
			if (!appValore.equals("")) {
				if(!validazione.sessoValido(appValore)) {
					System.out.println("ERRORE: formato sesso non valido");
					continue;
				}
				dipCopy.setSesso(appValore);
			}
			break;
		} while(true);
		
		do {
			appValore = leggiStringa("Codice Fiscale[" + dipCopy.getCodiceFiscale() + "]: ");
			if (!appValore.equals("")) {
				if(!validazione.codiceFiscaleValido(appValore)) {
					System.out.println("ERRORE: codice fiscale non valido");
					continue;
				}
				dipCopy.setCodiceFiscale(appValore);
			}
			break;
		} while(true);
		
		do {
			appValore = leggiStringa("Titolo di Studio[" + dipCopy.getTitoloDiStudio() + "]: ");
			if (!appValore.equals("")) {
				if(validazione.contieneNumeri(appValore)) {
					System.out.println("ERRORE: formato non valido");
					continue;
				}
				dipCopy.setTitoloDiStudio(appValore);
			}
			break;
		} while(true);
		
		do {
			appValore = leggiStringa("Ruolo aziendale[" + dipCopy.getRuoloAziendale() + "]: ");
			if (!appValore.equals("")) {
				if(validazione.contieneNumeri(appValore)) {
					System.out.println("ERRORE: formato non valido");
					continue;
				}
				dipCopy.setRuoloAziendale(appValore);
			}
			break;
		} while(true);
		
		do {
			appValore = leggiStringa("Stipendio[" + dipCopy.getStipendio() + "]: ");
			if (!appValore.equals("")) {
				if(validazione.valoreNegativo(appValore)) {
					System.out.println("ERRORE: stipendio negativo");
					continue;
				}
				dipCopy.setStipendio(Double.parseDouble(appValore));
			}
			break;
		} while(true);
		
		return dipCopy;
	}

	public void mascheraInserimento(Dipendente dip) {
		String appValore;
		Double stipendio;
		Date dataNascita;
		int id;
		
		System.out.println("*** Inserimento dipendente ***");
		
		do {
			appValore = leggiStringa("Inserisci id: ");
			// regex id
			if (!validazione.idValido(appValore)) {
				System.out.println("ERRORE: id non valido");
				continue;
			}
			id = Integer.parseInt(appValore);
			if (validazione.valoreNegativo(appValore)) {
				System.out.println("ERRORE: id negativo");
				continue;
			}
			id = Integer.parseInt(appValore);
			if (validazione.verificaId(id)) {
				System.out.println("ERRORE: id già presente");
				continue;
			}
			break;
		} while (true);
		dip.setId(id);
		//dip.setNome(leggiStringa("Nome: "));
		do {
			appValore = leggiStringa("Inserisci nome: ");
			if (validazione.campoVuoto(appValore)) {
				System.out.println("ERRORE: nome obbligatorio");
				continue; // interrompe immediatamente l’iterazione corrente e fa ripartire il ciclo
				// dall’inizio del do
			}
			if (validazione.contieneNumeri(appValore)) {
				System.out.println("ERRORE: nome non valido");
				continue;
			}
			break;
		} while (true); 
		dip.setNome(appValore);
		//dip.setCognome(leggiStringa("Cognome: "));
		do {
			appValore = leggiStringa("Inserisci cognome: ");
			if (validazione.campoVuoto(appValore)) {
				System.out.println("ERRORE: cognome obbligatorio");
				continue; // interrompe immediatamente l’iterazione corrente e fa ripartire il ciclo
				// dall’inizio del do
			}
			if (validazione.contieneNumeri(appValore)) {
				System.out.println("ERRORE: cognome non valido");
				continue;
			}
			break;
		} while (true);
		dip.setCognome(appValore);
		dip.setLuogoDiNascita(leggiStringa("Luogo di nascita: "));
		//dip.setDataDiNascita(leggiData("Data di nascita (aaaa-mm-gg): "));
		
		do {
			appValore = leggiStringa("Inserisci data nascita (yyyy-MM-dd): ");
			// regex data
			if (!validazione.dataValida(appValore)) {
				System.out.println("ERRORE: formato data non valido");
				continue;
			}
			try {
				dataNascita = Date.valueOf(appValore);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("ERRORE: data inesistente");
			}
		} while (true);
		dip.setDataDiNascita(dataNascita);
		//dip.setSesso(leggiStringa("Sesso: "));
		do {
			appValore = leggiStringa("Inserisci sesso (M/F/A): ").toUpperCase();
			if (!validazione.sessoValido(appValore)) {
				System.out.println("ERRORE: sesso non valido");
				continue;
			}
			break;
		} while (true);
		dip.setSesso(appValore);
		//dip.setCodiceFiscale(leggiStringa("Codice fiscale: "));
		do {
			appValore = leggiStringa("Inserisci codice fiscale: ").toUpperCase();
			if (!validazione.codiceFiscaleValido(appValore)) {
				System.out.println("ERRORE: codice fiscale non valido");
				continue;
			}
			break;
		} while (true);
		dip.setCodiceFiscale(appValore);
		dip.setTitoloDiStudio(leggiStringa("Titolo di Studio: "));
		dip.setRuoloAziendale(leggiStringa("Ruolo aziendale: "));
		//dip.setStipendio(leggiDecimale("Stipendio: "));
		
		do {
			appValore = leggiStringa("Inserisci stipendio: ");
			// regex stipendio
			if (!validazione.decimaleValido(appValore)) {
				System.out.println("ERRORE: stipendio non valido");
				continue;
			}
			stipendio = Double.parseDouble(appValore);
			if (validazione.valoreNegativo(appValore)) {
				System.out.println("ERRORE: stipendio negativo");
				continue;
			}
			break;
		} while (true);
		dip.setStipendio(stipendio);
	}

	public void schedaDipendente(Dipendente dipendente) {
		System.out.println("*** Scheda dipendente ***");
		//id
		//nome
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
	
	public Vista(Validazione validazione) {
		this.validazione = validazione;
	}
}
