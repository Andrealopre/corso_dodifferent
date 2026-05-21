package service;

import model.Cerchio;
import model.Poligono;
import model.Quadrato;
import model.Rettangolo;
import model.Triangolo;
import repository.RepositoryFigureGeometriche;
import view.Vista;

public class Geometria {
	private Vista vista;
	private RepositoryFigureGeometriche repository;
	
	
	public void start() {
		int scelta = 0;
		int sceltaFigura = 0;
		double[] lati;
		double lato;
		double raggio;
		String risposta = "";
		
		while(scelta != 3) {
			vista.menuPrincipale();
			scelta = vista.leggiIntero("Scegli: ");
			switch(scelta) {
			case 1:
				sceltaFigura = 0;
				while(sceltaFigura != 6) {
					vista.menuFigureGeometriche();
					sceltaFigura = vista.leggiIntero("Scegli la figura da inserire: ");
					switch(sceltaFigura) {
					case 1://inserimento quadrato
						lato = vista.mascheraQuadrato();
						Quadrato quadrato = new Quadrato(lato);
						repository.aggiungi(quadrato);
						risposta = vista.leggiStringa("Quadrato aggiunto. Premi invio per continuare");
						break;
					case 2://inserimento rettangolo
						lati = vista.mascheraRettangolo();
						Rettangolo rettangolo = new Rettangolo(lati[0], lati[1]);
						repository.aggiungi(rettangolo);
						risposta = vista.leggiStringa("Rettangolo aggiunto. Premi invio per continuare");
						break;
					case 3://inserimento triangolo
						lati = vista.mascheraTriangolo();
						Triangolo triangolo = new Triangolo(lati[0], lati[1], lati[2]);
						repository.aggiungi(triangolo);
						risposta = vista.leggiStringa("Quadrato aggiunto. Premi invio per continuare");
						break;
					case 4://inserimento poligono
						lati = vista.mascheraPoligono();
						Poligono poligono = new Poligono((int)lati[0], lati[1]);
						repository.aggiungi(poligono);
						risposta = vista.leggiStringa("Poligono aggiunto. Premi invio per continuare");
						break;
					case 5://inserimento cerchio
						raggio = vista.mascheraCerchio();
						Cerchio cerchio = new Cerchio(raggio);
						repository.aggiungi(cerchio);
						risposta = vista.leggiStringa("Cerchio aggiunto. Premi invio per continuare");
						break;
					}//fine switch inserimento
				}//fine ciclo inserimento
				break; //fine inserimento
			case 2:
				vista.visualizzaFigureGeometriche(repository.getFigure());
				risposta = vista.leggiStringa("Premi invio per uscire");
				break; //fine visualizza
			case 3:
				vista.visualizzaMessaggio("Esecuzione programma terminata");
				risposta = vista.leggiStringa("Premi invio per uscire");
				break; // esci
			}
		}
	}
	
	public Geometria() {
		this.vista = new Vista();
		repository = RepositoryFigureGeometriche.getInstance();
	}
}
