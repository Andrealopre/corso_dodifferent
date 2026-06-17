import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-triangolo',
  imports: [FormsModule],
  templateUrl: './triangolo.html',
  styleUrl: './triangolo.css',
})
export class Triangolo {
  latoA: number = 0;
  latoB: number = 0;
  latoC: number = 0;
  perimetro: number = 0;
  area: number = 0;

  constructor(latoA: number, latoB: number, latoC: number) {}

  calcolaPerimetro() {
    this.perimetro = this.latoA + this.latoB + this.latoC;
  }

  calcolaArea() {
    let p = (this.latoA + this.latoB + this.latoC) / 2;
    this.area = Math.sqrt(p * (p - this.latoA) * (p - this.latoB) * (p - this.latoC));
  }
}
