import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GestioneAttivita } from './components/gestione-attivita/gestione-attivita';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GestioneAttivita],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('attivita');
}
