import { Component } from '@angular/core';

interface Utente {
  nome: string,
  cognome: string
}

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {}
