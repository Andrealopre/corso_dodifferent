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
		int sceltaVisualizzazione = 0;
		int id = 0;
		int idCerca = 0;
		double[] lati;
		double lato;
		double raggio;
		String risposta = "";
		
		repository.carica();
		if(!repository.getFigure().isEmpty()) {
			id = repository.getFigure().getLast().getId() + 1;
		}
		while(scelta != 8) {
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
						Quadrato quadrato = new Quadrato(lato, id);
						repository.aggiungi(quadrato);
						id++;
						risposta = vista.leggiStringa("Quadrato aggiunto. Premi invio per continuare");
						break;
					case 2://inserimento rettangolo
						lati = vista.mascheraRettangolo();
						Rettangolo rettangolo = new Rettangolo(lati[0], lati[1], id);
						id++;
						repository.aggiungi(rettangolo);
						risposta = vista.leggiStringa("Rettangolo aggiunto. Premi invio per continuare");
						break;
					case 3://inserimento triangolo
						lati = vista.mascheraTriangolo();
						Triangolo triangolo = new Triangolo(lati[0], lati[1], lati[2], id);
						id++;
						repository.aggiungi(triangolo);
						risposta = vista.leggiStringa("Quadrato aggiunto. Premi invio per continuare");
						break;
					case 4://inserimento poligono
						lati = vista.mascheraPoligono();
						Poligono poligono = new Poligono((int)lati[0], lati[1], id);
						id++;
						repository.aggiungi(poligono);
						risposta = vista.leggiStringa("Poligono aggiunto. Premi invio per continuare");
						break;
					case 5://inserimento cerchio
						raggio = vista.mascheraCerchio();
						Cerchio cerchio = new Cerchio(raggio, id);
						id++;
						repository.aggiungi(cerchio);
						risposta = vista.leggiStringa("Cerchio aggiunto. Premi invio per continuare");
						break;
					}//fine switch inserimento
					repository.salva();
				}//fine ciclo inserimento
				break; //fine inserimento
			case 2:
				vista.visualizzaFigureGeometriche(repository.getFigure());
				risposta = vista.leggiStringa("Premi invio per uscire");
				break; //fine visualizza
			case 3:
				//lista ordinata per visualizzare le figure geometriche per tipo e 
				// per area
				vista.visualizzaFigureGeometriche(repository.getFigureOrdinato());
				risposta = vista.leggiStringa("Premi invio per uscire");
				break; //fine lista ordinata
			case 4:
				vista.visualizzaFigureGeometriche(repository.getFigureNoDuplicati());
				risposta = vista.leggiStringa("Premi invio per uscire");
				break;
			case 5:
				vista.visualizzaFigureGeometriche(repository.getFigureOrdinateNoDuplicati());
				risposta = vista.leggiStringa("Premi invio per uscire");
				break;
			case 6:
				vista.visualizzaReport(repository.getReport());
				risposta = vista.leggiStringa("Premi invio per uscire");
				break;
			case 7:
				idCerca = vista.leggiIntero("Inserisci l'id da cercare: ");
				vista.mascheraFiguraGeometrica(repository.cerca(idCerca));
				risposta = vista.leggiStringa("Premi invio per uscire: ");
				break;
			case 8:
				vista.visualizzaMessaggio("Esecuzione programma terminata");
				repository.salva();
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
