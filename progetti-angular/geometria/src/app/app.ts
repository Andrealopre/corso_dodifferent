import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink, RouterModule } from '@angular/router';
import { TutorialComponent } from './components/tutorial-component/tutorial-component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, RouterModule, TutorialComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('tutorial');
}