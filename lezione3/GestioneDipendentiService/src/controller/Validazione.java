package controller;

public class Validazione {
	private DAOService daoService;

	public boolean verificaId(int id) {
		return daoService.verificaId(id);
	}

	public boolean campoVuoto(String stringa) {
		if (stringa.isBlank()) {
			return true;
		}
		return false;
	}

	public boolean idValido(String id) {
		return id.matches("\\d{1,4}?$");
	}

	public boolean contieneNumeri(String stringa) {
		return !stringa.matches("^[A-Za-zÀ-ÿ\\s']{2,30}$");
	}

	public boolean dataValida(String data) {
		return data.matches("^\\d{4}-\\d{2}-\\d{2}$");
	}

	public boolean sessoValido(String sesso) {
		return sesso.matches("^[MFA]$");
	}

	public boolean codiceFiscaleValido(String codiceFiscale) {
		return codiceFiscale.matches("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$");
	}

	public boolean decimaleValido(String decimale) {
		return decimale.matches("^\\d+(\\.\\d{1,2})?$");
	}

	public boolean valoreNegativo(String valore) {
		if (decimaleValido(valore)) {
			return Double.valueOf(valore) < 0;
		}
		return Integer.valueOf(valore) < 0;
	}
	
	public Validazione(DAOService daoService) {
		this.daoService = daoService;
	}
}
