import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-figlio-uno',
  imports: [],
  templateUrl: './figlio-uno.html',
  styleUrl: './figlio-uno.css',
})
export class FiglioUno {
  @Input() conta: number = 0;
}
