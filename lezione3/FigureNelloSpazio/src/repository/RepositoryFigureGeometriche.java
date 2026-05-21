package repository;

import java.util.ArrayList;
import java.util.List;

import model.FiguraGeometrica;

public class RepositoryFigureGeometriche {
	private static RepositoryFigureGeometriche instance = null;
	private List<FiguraGeometrica> figure;
	
	public static RepositoryFigureGeometriche getInstance() {
		if(instance == null) {
			instance = new RepositoryFigureGeometriche();
		}
		
		return instance;
	}
	// Create
	public void aggiungi(FiguraGeometrica figura) {
		this.figure.add(figura);
	}
	// Read
	public List<FiguraGeometrica> getFigure() {
		return this.figure;
	}
	// Delete
	public void rimuovi(FiguraGeometrica figura) {
		this.figure.remove(figura);
	}
	
	public void modifica(int indice, FiguraGeometrica figura) {
		this.figure.set(indice, figura);
	}
	
	private RepositoryFigureGeometriche() {
		this.figure = new ArrayList<>();
	}
}
