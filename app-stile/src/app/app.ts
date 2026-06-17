import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Stile } from './components/stile/stile';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Stile],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('app-stile');
}
