package model;

import interfaces.IFiguraGeometrica;

public abstract class FiguraGeometrica implements IFiguraGeometrica {
	
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

	public FiguraGeometrica(String tipoFiguraGeometrica) {
		this.tipoFiguraGeometrica = tipoFiguraGeometrica;
	}
}
