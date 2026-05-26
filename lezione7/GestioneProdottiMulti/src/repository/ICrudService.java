package repository;

import java.util.List;

import model.*;

public interface ICrudService {
	public boolean inserisci(Prodotto prodotto);
	public List<Prodotto> leggi();
	public Prodotto leggi(int id);
	public Marca leggiMarca(int id);
	public Categoria leggiCategoria(int id);
	public Ordine leggiOrdine(int id);
	public boolean accoppia(Prodotto prodotto, Ordine ordine); //funzione per la molti a molti tra prodotti e ordini
	public boolean modifica(Prodotto prodotto);
	public boolean rimuovi(int id);
}
