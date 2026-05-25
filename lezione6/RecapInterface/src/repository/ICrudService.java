package repository;

import java.util.List;

public interface ICrudService {
	public boolean inserisci();
	public List<String> leggi();
	public String leggi(int id);
	public boolean modifica();
	public boolean rimuovi(int id);
}
