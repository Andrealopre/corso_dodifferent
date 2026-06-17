import { Component, OnInit, Input, OnChanges, Output, EventEmitter } from '@angular/core';
import { Prodotto } from '../listino/listino';


@Component({
  selector: 'app-carrello',
  templateUrl: './carrello.component.html',
  styleUrls: ['./carrello.component.css']
})
export class CarrelloComponent implements OnInit, OnChanges {
  @Input() prodotto: Prodotto = {
    id: 0,
    prodotto: '',
    prezzo: 0,
    quantita: 0
  };
  @Output() eliminaprodotto = new EventEmitter();
  carrello: Prodotto[] = new Array();
  constructor() { }
  aggiungiAlCarrello(): void {
    let indice = this.controllaIndice();
    if (indice == -1) {
      this.carrello.push(this.prodotto);
    }
  }

  controllaIndice(): number {
    for (let p of this.carrello) {
      if (p.id == this.prodotto.id) {
        p.quantita += 1
        return p.id;
      }
    }
    return -1
  }

  eliminaUnProdotto(id: number): void {
    let indice: number = 0
    for (let p of this.carrello) {
      if (p.id == id) {
        if (p.quantita > 1) {
          p.quantita -= 1
          break;
        } else {
          this.carrello.splice(indice, 1)
        }
      }
      indice++
    }
    this.eliminaprodotto.emit(id)
  }

  ngOnInit(): void {
  }

  ngOnChanges() {
    if (this.prodotto)
      this.aggiungiAlCarrello()
  }
}