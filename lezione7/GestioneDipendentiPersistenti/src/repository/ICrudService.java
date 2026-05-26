package repository;

import java.util.List;

import model.*;

public interface ICrudService {
	public boolean inserisciAccount(Account account);
	public boolean inserisciDipendente(Dipendente dipendente);
	public boolean inserisciRuoloAziendale(RuoloAziendale ruoloAziendale);
	public List<RuoloAziendale> leggiRuoliAziendali();
	public List<Dipendente> leggiDipendenti();
	public Account leggiAccount(int id);
	public RuoloAziendale leggiRuoloAziendale(int id);
	public Account leggiAccount(Account account);
}
