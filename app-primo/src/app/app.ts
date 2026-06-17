import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Figlio } from './components/figlio/figlio';
import { AppGiorno } from './components/app-giorno/app-giorno';
import { UtenteAvanzato } from './components/utente-avanzato/utente-avanzato';
import { Padre } from './components/padre/padre';
import { FiglioUno } from './components/figlio-uno/figlio-uno';
import { Listino } from './acquisto-prodotti/listino/listino';
import { Carrello } from './acquisto-prodotti/carrello/carrello';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Figlio, AppGiorno, UtenteAvanzato, Padre, FiglioUno,
    Listino, Carrello
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('app-primo');
}
