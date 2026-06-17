import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cerchio',
  imports: [FormsModule],
  templateUrl: './cerchio.html',
  styleUrl: './cerchio.css',
})
export class Cerchio {
  raggio: number = 0;
  perimetro: number = 0;
  area: number = 0;

  calcolaPerimetro() {
    this.perimetro = (this.raggio * this.raggio) * Math.PI;
  }
}
