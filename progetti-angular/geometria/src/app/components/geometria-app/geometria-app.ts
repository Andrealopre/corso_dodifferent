import { Component } from '@angular/core';
import { Quadrato } from '../geometria/quadrato/quadrato';
import { Rettangolo } from '../geometria/rettangolo/rettangolo';
import { Triangolo } from '../geometria/triangolo/triangolo';
import { Cerchio } from '../geometria/cerchio/cerchio';

export interface Forma {
  calcolaArea(): void;
  calcolaPerimetro(): void;
}

@Component({
  selector: 'app-geometria-app',
  imports: [],
  templateUrl: './geometria-app.html',
  styleUrl: './geometria-app.css',
})
export class GeometriaApp {
  forma!: Forma;
  idForma = 1;

  calcola(valori: any) {
    switch(this.idForma) {
      case 1:
        this.forma = new Quadrato(valori.lato);
        break;
      case 2:
        this.forma = new Rettangolo(valori.base, valori.altezza);
        break;
      case 3:
        this.forma = new Triangolo(valori.latoA, valori.latoB, valori.latoC);
        break;
      case 4:
        this.forma = new Cerchio(valori.raggio);
        break;
    }
  }
}
