import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-quadrato',
  imports: [FormsModule],
  templateUrl: './quadrato.html',
  styleUrl: './quadrato.css',
})
export class Quadrato {
  lato: number = 0;
  perimetro: number = 0;
  area: number = 0;

  constructor(lato: number) {}

  calcolaPerimetro() {
    this.perimetro = this.lato * 4;
  }

  calcolaArea() {
    this.area = this.lato * this.lato;
  }
}
