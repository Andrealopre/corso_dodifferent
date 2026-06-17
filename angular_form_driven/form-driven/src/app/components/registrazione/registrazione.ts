import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PersonaService, Utente } from '../../persone/persona-service';

@Component({
  selector: 'app-registrazione',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './registrazione.html',
  styleUrl: './registrazione.css',
})
export class Registrazione {
  id = 0;

  constructor(private personaService: PersonaService) {
  }

  onSubmit(salva: NgForm) {
    if(salva.invalid) {
      salva.control.markAllAsTouched();
      return;
    }
    this.id++;
    let utente: Utente = {
      id : this.id,
      nome : salva.value.nome,
      cognome : salva.value.cognome,
      luogoDiNascita : salva.value.luogoNascita,
      dataDiNascita : salva.value.dataNascita,
      sesso : salva.value.sesso,
      titoloDiStudio : salva.value.titoloStudio,
      codiceFiscale : salva.value.codiceFiscale
    };
    this.personaService.aggiungiPersona(utente);
  }

  pulisciCampi(salva: any) {
    salva.resetForm();
  }
}
