package controller;

import java.sql.Connection;
import java.util.List;

import connettore.Connettore;
import model.Prodotto;
import repository.CrudService;
import repository.ICrudService;

public class Avvio {

	public static void main(String[] args) {
//		Connettore connettore = new Connettore();
//		Connection conn = connettore.apriConnessione();
//		if(conn != null) {
//			System.out.println("Connessione avvenuta con successo!");
//		} else {
//			System.err.println("Connessione fallita");
//		}
		
		Prodotto prodotto = new Prodotto();
		ICrudService crud = new CrudService();
		int scelta = 0;
		
//		prodotto.setNomeProdotto("Maglia Barcellona");
//		prodotto.setPrezzo(100.99);
//		prodotto.setQuantita(10);
//		prodotto.setId(1);
//		prodotto.setCategoria("Abbigliamento");
//		prodotto.setMarca("Nike");
//		if(crud.inserisci(prodotto)) {
//			System.out.println("Inserimento avvenuto con successo!");
//		} else {
//			System.err.println("Inserimento fallito!");
//		}
//		if(crud.modifica(prodotto)) {
//			System.out.println("Aggiornamento avvenuto con successo");
//		} else {
//			System.err.println("Aggiornamento fallito");
//		}
//		if(crud.rimuovi(prodotto.getId())) {
//			System.out.println("Rimozione avvenuta con successo");
//		} else {
//			System.err.println("Rimozione fallita");
//		List<Prodotto> prodotti = crud.leggi();
//		System.out.println("SCHEDA PRODOTTO");
//		for(Prodotto p : prodotti) {
//			System.out.println("Id: " + p.getId());
//			System.out.println("Nome prodotto: " + p.getNomeProdotto());
//			System.out.println("Prezzo: " + p.getPrezzo());
//			System.out.println("Quantita: " + p.getQuantita());
//			System.out.println("Marca: " + p.getMarca());
//			System.out.println("Categoria: " + p.getCategoria());
//			System.out.println("-------------------------------------");
//			System.out.println();
//		}
		prodotto = crud.leggi(4);
		System.out.println(prodotto.toString());
		
	}
}
