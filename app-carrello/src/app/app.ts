import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CarrelloComponent } from './components/carrello/carrello';
import { ListinoComponent } from './components/listino/listino';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CarrelloComponent, ListinoComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('app-carrello');
}
