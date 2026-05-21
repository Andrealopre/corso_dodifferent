package model;

import java.util.Objects;

public class Poligono extends FiguraGeometrica {
	private int numeroLati;
	private double lato;
	private static String[] nomiPoligoni = {
			"Triangolo",
			"Quadrilatero",
			"Pentagono",
			"Esagono",
			"Ettagono",
			"Ottagono",
			"Ennagono",
			"Decagono",
			"Endecagono",
			"Dodecagono",
			"Tridecagono",
			"Tetradecagono",
			"Pentadecagono",
			"Esadecagono",
			"Eptadecagono",
			"Ottadecagono",
			"Ennadecagono",
			"Icosagono"
	}; 
	
	@Override
	public double getPerimetro() {
		return this.numeroLati * this.lato;
	}
	@Override
	public double getArea() {
		return (getPerimetro() * getApotema()) / 2;
	}
	public int getNumeroLati() {
		return numeroLati;
	}
	public void setNumeroLati(int numeroLati) {
		this.numeroLati = numeroLati;
	}
	public double getLato() {
		return lato;
	}
	public void setLato(double lato) {
		this.lato = lato;
	}
	private double getApotema() {
		return this.lato / (2 * Math.tan(Math.PI / this.numeroLati));
	}
	@Override
	public int hashCode() {
		return Objects.hash(lato, numeroLati);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poligono other = (Poligono) obj;
		return Double.doubleToLongBits(lato) == Double.doubleToLongBits(other.lato)
				&& numeroLati == other.numeroLati;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + ";"
				+ this.getNumeroLati() + ";"
				+ this.getLato();
				
	}
	public Poligono(int numeroLati, double lato, int id) {
		super(nomiPoligoni[numeroLati - 3], id);
		
		this.numeroLati = numeroLati;
		this.lato = lato;
	}
	
}
