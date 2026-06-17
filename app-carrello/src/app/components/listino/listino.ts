import { Component, OnInit } from '@angular/core';

export interface Prodotto {
  id: number
  prodotto: string
  prezzo: number
  quantita: number
}

@Component({
  selector: 'app-listino',
  templateUrl: './listino.component.html',
  styleUrls: ['./listino.component.css']
})
export class ListinoComponent implements OnInit {
  prodotti: Prodotto[] = [];
  prodotto: Prodotto = {
    id : 0,
    prodotto : '',
    prezzo : 0,
    quantita : 0
  };
  constructor() {
    this.creaListino()
  }

  creaListino() {
    this.prodotti.push({ id: 1, prodotto: "camicia", prezzo: 50, quantita: 10 })
    this.prodotti.push({ id: 2, prodotto: "maglione", prezzo: 60, quantita: 5 })
    this.prodotti.push({ id: 3, prodotto: "TV 40\"", prezzo: 500, quantita: 3 })
    this.prodotti.push({ id: 4, prodotto: "Notebook", prezzo: 600, quantita: 8 })
    this.prodotti.push({ id: 5, prodotto: "Deodorante", prezzo: 5, quantita: 10 })
    this.prodotti.push({ id: 6, prodotto: "Profumo", prezzo: 150, quantita: 15 })
  }

  aggiungiAlCarrello(id: number) {
    let indice: number = Number(id) - 1
    if (this.prodotti[indice].quantita > 0) {
      this.prodotti[indice].quantita -= 1
      this.prodotto.id = this.prodotti[indice].id
      this.prodotto.prodotto = this.prodotti[indice].prodotto
      this.prodotto.prezzo = this.prodotti[indice].prezzo
      this.prodotto.quantita = 1
    }
  }

  eliminaProdotto(id: number) {
    for (let p of this.prodotti) {
      if (p.id == id) {
        p.quantita += 1
        break;
      }
    }
  }
  ngOnInit(): void {
  }
}

