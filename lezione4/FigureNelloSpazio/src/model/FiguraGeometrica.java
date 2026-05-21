package model;

import java.util.Objects;

import interfaces.IFiguraGeometrica;

public abstract class FiguraGeometrica implements IFiguraGeometrica, Comparable<FiguraGeometrica> {
	
	private String tipoFiguraGeometrica;
	private int id;
	
	@Override
	public String getTipoFigura() {
		return this.tipoFiguraGeometrica;
	}
	
	@Override
	public abstract double getPerimetro();
	
	@Override
	public abstract double getArea();
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.getId() + ";" + this.getTipoFigura();
	}
	
	// Collections.sort(lista) per ordinare una lista
	public int compareTo(FiguraGeometrica altraFigura) {
		// | Valore | Significato |
		// | ------ | ------------ |
		// | < 0 | this < altro |
		// | 0 | uguali |
		// | > 0 | this > altro |
		// 1. confronto tipo figura
		int confrontoTipo = this.tipoFiguraGeometrica.compareTo(altraFigura.tipoFiguraGeometrica);
		// se diversi ritorna subito
		if (confrontoTipo != 0) {
			return confrontoTipo;
		}
		// 2. confronto area
		return Double.compare(this.getArea(), altraFigura.getArea());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getClass(), this.getArea());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiguraGeometrica other = (FiguraGeometrica) obj;
		return Objects.equals(tipoFiguraGeometrica, other.tipoFiguraGeometrica)
				&& Objects.equals(this.getArea(), other.getArea());
	}

	public FiguraGeometrica(String tipoFiguraGeometrica, int id) {
		this.tipoFiguraGeometrica = tipoFiguraGeometrica;
		this.id = id;
	}
}
