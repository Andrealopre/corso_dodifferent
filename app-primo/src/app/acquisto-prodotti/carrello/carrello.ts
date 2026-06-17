import { Component } from '@angular/core';
import { Listino } from '../listino/listino';

interface Prodotto {
  id: number;
  prodotto: string;
  prezzo: number;
}

@Component({
  selector: 'app-carrello',
  imports: [Listino],
  templateUrl: './carrello.html',
  styleUrl: './carrello.css',
})
export class Carrello {
  prodotti: Prodotto[] = [];
  title = "Carrello";
  id = 0;
  prodotto = "-";
  prezzo = 0;
  totalePrezzo = 0;

  aggiungiProdotto(evento: Prodotto) {

    this.id = evento.id;
    this.prodotto = evento.prodotto;
    this.prezzo = evento.prezzo;
    this.totalePrezzo += this.prezzo;
    this.prodotti.push({ id: this.id, prodotto: this.prodotto, prezzo: this.prezzo });
  }


  azzeraCarrello() {
    this.prodotti = [];
    this.totalePrezzo = 0;
  }
}

