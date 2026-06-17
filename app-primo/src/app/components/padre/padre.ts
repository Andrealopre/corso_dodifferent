import { Component } from '@angular/core';
import { FiglioUno } from '../figlio-uno/figlio-uno';

@Component({
  selector: 'app-padre',
  imports: [FiglioUno],
  templateUrl: './padre.html',
  styleUrl: './padre.css',
})
export class Padre {
  titolo = 'Contatore';
  locConta: number = 0;

  incrementaContatore() {
    this.locConta++;
  }
}
