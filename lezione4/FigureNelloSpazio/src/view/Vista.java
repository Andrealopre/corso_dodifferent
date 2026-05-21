package view;

import java.util.List;
import java.util.Scanner;

import model.Cerchio;
import model.FiguraGeometrica;
import model.Poligono;
import model.Quadrato;
import model.Rettangolo;
import model.Triangolo;
import repository.Dati;

public class Vista {

	public void menuPrincipale() {
		System.out.println("*** Menu Principale ***");
		System.out.println("1) Inserimento figura");
		System.out.println("2) Visualizza figura");
		System.out.println("3) Lista ordinata");
		System.out.println("4) Lista senza duplicati");
		System.out.println("5) Lista ordinata senza duplicati");
		System.out.println("6) Statistiche");
		System.out.println("7) Cerca");
		System.out.println("8) Esci");
	}

	public void menuFigureGeometriche() {
		System.out.println("*** Menu Figure Geometriche");
		System.out.println("1) Quadrato");
		System.out.println("2) Rettangolo");
		System.out.println("3) Triangolo");
		System.out.println("4) Poligono");
		System.out.println("5) Cerchio");
		System.out.println("6) Esci");
	}
	
	public double mascheraQuadrato() {
		double lato;
		System.out.println("*** Inserimento Quadrato ***");
		lato = leggiDecimale("Inserisci il lato: ");
		return lato;
	}

	public double[] mascheraRettangolo() {
		double[] lati = new double[2];
		System.out.println("*** Inserimento Rettangolo ***");
		lati[0] = leggiDecimale("Inserisci il lato minore: ");
		lati[1] = leggiDecimale("Inserisci il lato maggiore: ");
		return lati;
	}

	public double[] mascheraTriangolo() {
		double[] lati = new double[3];
		String risposta;
		
		System.out.println("*** Inserimento Triangolo ***");
		do {
			lati[0] = leggiDecimale("Inserisci il lato A: ");
			lati[1] = leggiDecimale("Inserisci il lato B: ");
			lati[2] = leggiDecimale("Inserisci il lato C: ");
			if (lati[0] > 0 && lati[1] > 0 && lati[2] > 0 &&
					lati[0] + lati[1] > lati[2] &&
					lati[0] + lati[2] > lati[1] &&
					lati[1] + lati[2] > lati[0]) {
				return lati;
			} else {
				System.out.println("La lunghezza dei lati non è corretta!");
				risposta = this.leggiStringa("Premi un tasto per continuare");
			}
		} while(true);
		//return lati;
	}

	public double[] mascheraPoligono() {
		double[] lati = new double[2];
		System.out.println("*** Inserimento Poligono ***");
		lati[0] = leggiDecimale("Inserisci il numero di lati: ");
		while(lati[0] < 3 && lati[0] > 20) {
			System.out.println("Inserire un numero di lati compreso tra 3 e 20");
			lati[0] = leggiIntero("Inserire il numero di lati");
		}
		lati[1] = leggiDecimale("Inserisci la lunghezza del lato: ");

		return lati;
	}

	public double mascheraCerchio() {
		double raggio;
		System.out.println("*** Inserimento Cerchio ***");
		raggio = leggiDecimale("Inserisci il raggio: ");
		return raggio;
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

	public void visualizzaFigureGeometriche(List<FiguraGeometrica> figure) {
		System.out.println();
		this.visualizzaMessaggio("*** Lista Figure Geometriche ***");
		for (FiguraGeometrica fig : figure) {
			this.mascheraFiguraGeometrica(fig);
		}
	}
	
	public void visualizzaReport(List<Dati> dati) {
		System.out.println("*** Report Statistiche ***");
		for(Dati dato : dati) {
			System.out.println("Tipo Figura: " + dato.getTipo());
			System.out.println("Occorrenze: " + dato.getContatore());
		}
	}

	public void mascheraFiguraGeometrica(FiguraGeometrica figura) {
		System.out.println("Id: " + figura.getId());
		System.out.println("Tipo figura geometrica: " + figura.getTipoFigura());
		System.out.println("Perimetro: " + figura.getPerimetro());
		System.out.println("Area: " + figura.getArea());
		this.tipoFigura(figura);
		System.out.println("-----------------------------------------------");
	}

	public void tipoFigura(FiguraGeometrica figura) {
		if (figura instanceof Poligono) {
			System.out.println("Numero lati: " + ((Poligono) figura).getNumeroLati());
			System.out.println("Lunghezza dei lati: " + ((Poligono) figura).getLato());
		}
		if (figura instanceof Triangolo) {
			System.out.println("Numero lati: " + 3);
			System.out.println("Lato A: " + ((Triangolo) figura).getLatoA());
			System.out.println("Lato B: " + ((Triangolo) figura).getLatoB());
			System.out.println("Lato C: " + ((Triangolo) figura).getLatoC());
		}
		if (figura instanceof Rettangolo) {
			System.out.println("Numero lati: " + 4);
			System.out.println("Lato minore: " + ((Rettangolo) figura).getLatoMinore());
			System.out.println("Lato maggiore: " + ((Rettangolo) figura).getLatoMaggiore());
		}
		if (figura instanceof Quadrato) {
			System.out.println("Numero lati: " + 4);
			System.out.println("Lunghezza lati: " + ((Quadrato) figura).getLato());
		}
		if (figura instanceof Cerchio) {
			System.out.println("Lunghezza raggio: " + ((Cerchio) figura).getRaggio());
		}
	}

	public void visualizzaMessaggio(String messaggio) {
		System.out.println(messaggio);
	}
}
