package model;

import java.util.Objects;

public class Cerchio extends FiguraGeometrica {
	private double raggio;
	
	@Override
	public double getPerimetro() {
		return 2 * Math.PI * this.raggio;
	}
	@Override
	public double getArea() {
		return Math.pow(this.raggio, 2) * Math.PI;
	}
	public double getRaggio() {
		return this.raggio;
	}
	public void setRaggio(double raggio) {
		this.raggio = raggio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(raggio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerchio other = (Cerchio) obj;
		return Double.doubleToLongBits(raggio) == Double.doubleToLongBits(other.raggio);
	}
	
	@Override
	public String toString() {
		return super.toString() + ";" 
				+ this.getRaggio(); 
	}
	public Cerchio(double raggio, int id) {
		super("Cerchio", id);
		this.raggio = raggio;
	}
	
}
