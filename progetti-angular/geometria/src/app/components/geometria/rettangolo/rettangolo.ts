import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-rettangolo',
  imports: [FormsModule],
  templateUrl: './rettangolo.html',
  styleUrl: './rettangolo.css',
})
export class Rettangolo {
  base: number = 0;
  altezza: number = 0;
  perimetro: number = 0;
  area: number = 0;

  constructor(base: number, altezza: number) {}

  calcolaPerimetro() {
    this.perimetro = (this.base + this.altezza) * 2;
  }

  calcolaArea() {
    this.area = this.base * this.altezza
  }
}
