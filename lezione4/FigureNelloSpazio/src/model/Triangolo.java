package model;

import java.util.Objects;

public class Triangolo extends FiguraGeometrica {
	private double latoA;
	private double latoB;
	private double latoC;
	
	@Override
	public double getPerimetro() {
		return latoA + latoB + latoC;
	}
	@Override
	public double getArea() {
		double sp;
		double area;
		sp = getPerimetro() / 2;
		area = Math.sqrt(sp 
				* (sp - this.latoA)
				* (sp - this.latoB)
				* (sp - this.latoC));
		return area;
	}
	public double getLatoA() {
		return latoA;
	}
	public void setLatoA(double latoA) {
		this.latoA = latoA;
	}
	public double getLatoB() {
		return latoB;
	}
	public void setLatoB(double latoB) {
		this.latoB = latoB;
	}
	public double getLatoC() {
		return latoC;
	}
	public void setLatoC(double latoC) {
		this.latoC = latoC;
	}
	@Override
	public int hashCode() {
		return Objects.hash(latoA, latoB, latoC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangolo other = (Triangolo) obj;
		return Double.doubleToLongBits(latoA) == Double.doubleToLongBits(other.latoA)
				&& Double.doubleToLongBits(latoB) == Double.doubleToLongBits(other.latoB)
				&& Double.doubleToLongBits(latoC) == Double.doubleToLongBits(other.latoC);
	}
	
	@Override
	public String toString() {
		return super.toString() + ";"
				+ this.getLatoA() + ";"
				+ this.getLatoB() + ";"
				+ this.getLatoC(); 
	}
	public Triangolo(double latoA, double latoB, double latoC, int id) {
		super("Triangolo", id);
		this.latoA = latoA;
		this.latoB = latoB;
		this.latoC = latoC;
	}
	
	
}
