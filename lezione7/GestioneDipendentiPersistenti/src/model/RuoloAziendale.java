package model;

public class RuoloAziendale {
	private int idRuoloAziendale;
	private String ruoloAziendale;
	private String mansione;
	
	public RuoloAziendale() {
		
	}

	public RuoloAziendale(int idRuoloAziendale, String ruoloAziendale, String mansione) {
		super();
		this.idRuoloAziendale = idRuoloAziendale;
		this.ruoloAziendale = ruoloAziendale;
		this.mansione = mansione;
	}

	public int getIdRuoloAziendale() {
		return idRuoloAziendale;
	}

	public void setIdRuoloAziendale(int idRuoloAziendale) {
		this.idRuoloAziendale = idRuoloAziendale;
	}

	public String getRuoloAziendale() {
		return ruoloAziendale;
	}

	public void setRuoloAziendale(String ruoloAziendale) {
		this.ruoloAziendale = ruoloAziendale;
	}

	public String getMansione() {
		return mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	@Override
	public String toString() {
		return "RuoloAziendale [idRuoloAziendale=" + idRuoloAziendale + ", ruoloAziendale=" + ruoloAziendale
				+ ", mansione=" + mansione + "]";
	}

}
