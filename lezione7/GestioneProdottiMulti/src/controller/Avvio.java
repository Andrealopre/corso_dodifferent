package controller;

import java.sql.Connection;
import java.util.List;

import connettore.Connettore;
import model.*;
import repository.CrudService;
import repository.ICrudService;

public class Avvio {

	public static void main(String[] args) {
//		Connettore connettore = new Connettore();
//		Connection conn = connettore.apriConnessione();
//		if(conn!=null) {
//			System.out.println("Connessione avvenuta con successo!");
//		}else {
//			System.err.println("Connessione fallita!");
//		}
		ICrudService crud = new CrudService();
		Prodotto prodotto = new Prodotto();
		//prodotto.setId(1); //Scommenta se vuoi modificare
		prodotto.setNomeProdotto("Maglia Barcellona FC");
		prodotto.setPrezzo(89.99);
		prodotto.setQuantita(10);
		//Relazione prodotti-marche: passiamo ad un oggetto di tipo Prodotto un riferimento di Marca
		Marca marca = crud.leggiMarca(1); //id=1 -> nike
		prodotto.setMarca(marca);
		//Relazione prodotti-categorie: passiamo ad un oggetto di tipo Prodotto un riferimento di Categoria
		Categoria categoria = crud.leggiCategoria(1); //id=1 -> abbigliamento
		prodotto.setCategoria(categoria);
		//1)Test inserimento
		if(crud.inserisci(prodotto)) {
			System.out.println("Inserimento avvenuto con successo!");
		}else {
			System.err.println("Inserimento fallito!");
		}
		//2)Test modifica
//		if(crud.modifica(prodotto)) {
//			System.out.println("Aggiornamento avvenuto con successo!");
//		}else {
//			System.err.println("Aggiornamento fallito!");
//		}
		//3)Test rimozione
//		if(crud.rimuovi(prodotto.getId())) {
//			System.out.println("Rimozione avvenuta con successo!");
//		}else {
//			System.err.println("Rimozione fallita!");
//		}
		//4)Test leggi tutti i prodotti
		List<Prodotto> prodotti = crud.leggi();
		for(Prodotto p:prodotti) { //forEach
			System.out.println("SCHEDA PRODOTTO:");
			System.out.println("ID: "+p.getId());
			System.out.println("Nome prodotto: "+p.getNomeProdotto());
			System.out.println("Prezzo: "+p.getPrezzo());
			System.out.println("Marca: "+p.getMarca().getNomeMarca());
			System.out.println("Categoria: "+p.getCategoria().getNomeCategoria());
			System.out.println(); //spazio finale
		}
		//5)Test cerca un prodotto per id
		prodotto = crud.leggi(2);
		if(prodotto!=null) {
			System.out.println("Prodotto trovato");
			System.out.println("Nome prodotto: "+prodotto.getNomeProdotto());
		}else {
			System.err.println("Prodotto non trovato");
		}
		//6)Accoppiamo prodotti ed ordini
		//Esempio: associamo al primo ordine i primi due prodotti 
		Ordine ordine = crud.leggiOrdine(1);
		prodotto = crud.leggi(1);
		if(crud.accoppia(prodotto, ordine)) {
			System.out.println("Prodotto associato correttamente nell'ordine");
		}else {
			System.err.println("Associazione fallita!!!");
		}
		prodotto = crud.leggi(2);
		if(crud.accoppia(prodotto, ordine)) {
			System.out.println("Prodotto associato correttamente nell'ordine");
		}else {
			System.err.println("Associazione fallita!!!");
		}
	}
}
