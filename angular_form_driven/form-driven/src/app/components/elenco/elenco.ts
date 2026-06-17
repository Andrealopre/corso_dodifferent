import { Component } from '@angular/core';
import { PersonaService } from '../../persone/persona-service';
import { Utente } from '../../persone/persona-service';

@Component({
  standalone: true,
  selector: 'app-elenco',
  imports: [],
  templateUrl: './elenco.html',
  styleUrl: './elenco.css',
})
export class Elenco {
  constructor(private personaService: PersonaService) {};
  persone: Utente[] = [];
  
  ngOnInit(): void {
    this.persone = this.personaService.getPersone();
  }

  eliminaUtente(index: number) {
    this.personaService.eliminaUtente(index);
  }
}
