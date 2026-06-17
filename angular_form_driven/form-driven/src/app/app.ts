import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { Principale } from './components/principale/principale';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Principale, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('form-driven');
}
