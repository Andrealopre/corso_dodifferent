package repository;

import java.util.List;

import model.*;

public interface ICrudService {
	public boolean inserisciAccount(Account account);
	public Account leggiAccount(int id);
	public Account leggiAccount(Account account);
	public boolean inserisciDipendente(Dipendente dipendente);
	public boolean inserisciRuoloAziendale(RuoloAziendale ruoloAziendale);
	public boolean rimuovi(int id);
	public boolean modificaStringa(int id, String colonna, String valore);
	public boolean modificaDecimale(int id, String colonna, Double valore);
	public boolean modificaIntero(int id, String colonna, int valore);
	public List<Dipendente> leggiDipendenti();
	public Dipendente leggiDipendente(int id);
	public List<RuoloAziendale> leggiRuoliAziendali();	
	public RuoloAziendale leggiRuoloAziendale(int id);
	
}
