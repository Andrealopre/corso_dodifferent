package model;

import java.util.Objects;

public class Rettangolo extends FiguraGeometrica {
	private double latoMinore;
	private double latoMaggiore;
	
	@Override
	public double getPerimetro() {
		return 2 * (latoMinore + latoMaggiore);
	}
	@Override
	public double getArea() {
		return latoMinore * latoMaggiore;
	}
	
	public double getLatoMinore() {
		return latoMinore;
	}
	public void setLatoMinore(double latoMinore) {
		this.latoMinore = latoMinore;
	}
	public double getLatoMaggiore() {
		return latoMaggiore;
	}
	public void setLatoMaggiore(double latoMaggiore) {
		this.latoMaggiore = latoMaggiore;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(latoMaggiore, latoMinore);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rettangolo other = (Rettangolo) obj;
		return Double.doubleToLongBits(latoMaggiore) == Double.doubleToLongBits(other.latoMaggiore)
				&& Double.doubleToLongBits(latoMinore) == Double.doubleToLongBits(other.latoMinore);
	}
	
	@Override
	public String toString() {
		return super.toString() + ";"
				+ this.getLatoMinore() + ";"
				+ this.getLatoMaggiore();
	}
	public Rettangolo(double latoMinore, double latoMaggiore, int id) {
		super("Rettangolo", id);
		this.latoMinore = latoMinore;
		this.latoMaggiore = latoMaggiore;
	}
}
