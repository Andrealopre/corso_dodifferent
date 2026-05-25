package repository;

import java.util.List;

import model.Prodotto;

public interface ICrudService {
	public boolean inserisci(Prodotto prodotto);
	public List<Prodotto> leggi();
	public Prodotto leggi(int id);
	public boolean modifica(Prodotto prodotto);
	public boolean rimuovi(int id);
}
