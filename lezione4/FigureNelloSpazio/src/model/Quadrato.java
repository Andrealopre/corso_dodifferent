package model;

import java.util.Objects;

public class Quadrato extends FiguraGeometrica {
	
	private double lato;
	
	@Override
	public double getPerimetro() {
		return this.lato * 4;
	}
	@Override
	public double getArea() {
		return this.lato * this.lato;
	}
	public double getLato() {
		return this.lato;
	}
	public void setLato(double lato) {
		this.lato = lato;
	}
	@Override
	public int hashCode() {
		return Objects.hash(lato);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quadrato other = (Quadrato) obj;
		return Double.doubleToLongBits(lato) == Double.doubleToLongBits(other.lato);
	}
	
	@Override
	public String toString() {
		return super.toString() + ";"
				+ this.getLato();
	}
	public Quadrato(double lato, int id) {
		super("Quadrato", id);
		this.lato = lato;
	}
}
