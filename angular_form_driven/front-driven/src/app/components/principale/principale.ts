import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-principale',
  imports: [FormsModule, RouterLink],
  templateUrl: './principale.html',
  styleUrl: './principale.css',
})
export class Principale {}
