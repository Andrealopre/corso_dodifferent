import { Component, Output, EventEmitter } from '@angular/core';

interface Prodotto {
  id: number;
  prodotto: string;
  prezzo: number;
}

@Component({
  selector: 'app-listino',
  imports: [],
  templateUrl: './listino.html',
  styleUrl: './listino.css',
})
export class Listino {
  nome = "Listino";
  indice: number = 0;
  prodotti: Prodotto[] = [];
  @Output() aggiungi = new EventEmitter();

  constructor() {
    this.prodotti.push({ id: 1, prodotto: "Matita", prezzo: 2});
    this.prodotti.push({ id: 2, prodotto: "Penna", prezzo: 3});
    this.prodotti.push({ id: 3, prodotto: "Forbici", prezzo: 5});
    this.prodotti.push({ id: 4, prodotto: "Righello", prezzo: 8});
    this.prodotti.push({ id: 5, prodotto: "Gomma", prezzo: 2});
  }

  aggiungiCarrello(indice: number) {
    this.indice = indice;
    this.aggiungi.emit(this.prodotti[indice]);
  }
}
