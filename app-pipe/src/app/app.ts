import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PipeComponent } from './components/pipe-component/pipe-component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PipeComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('app-pipe');
}
