import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { routes } from '../../app.routes';

@Component({
  selector: 'app-tutorial-component',
  imports: [RouterLink],
  templateUrl: './tutorial-component.html',
  styleUrl: './tutorial-component.css',
})
export class TutorialComponent {}
