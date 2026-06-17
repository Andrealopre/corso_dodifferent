import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

export interface Utente {
  nome: string;
  cognome: string;
  luogoDiNascita: string;
  sesso: string;
}

@Component({
  selector: 'app-utente-avanzato',
  imports: [FormsModule],
  templateUrl: './utente-avanzato.html',
  styleUrl: './utente-avanzato.css',
})
export class UtenteAvanzato {
  repo: Utente[] = [];
  nome: string = '';
  cognome: string = '';
  luogoDiNascita: string = '';
  sesso: string = '';
  utenteRegistrato: Utente = {
    nome: '',
    cognome: '',
    luogoDiNascita: '',
    sesso: ''
  };
  mostraListaUtenti: boolean = false;

  salvaUtente(): void {
    this.nome = this.utenteRegistrato.nome;
    this.cognome = this.utenteRegistrato.cognome;
    this.luogoDiNascita = this.utenteRegistrato.luogoDiNascita;
    this.sesso = this.utenteRegistrato.sesso;

    let utente: Utente = {
      nome : this.nome,
      cognome : this.cognome,
      luogoDiNascita : this.luogoDiNascita,
      sesso : this.sesso
    }
    this.repo.push(utente);
  }

  cancellaCampi(): void {
    this.utenteRegistrato.nome = '';
    this.utenteRegistrato.cognome = '';
    this.utenteRegistrato.luogoDiNascita = '';
    this.utenteRegistrato.sesso = '';
  }

  stampaUtenti(): void {
    this.repo.forEach(utente => {
      console.log('Nome: ' + utente.nome);
      console.log('Cognome: ' + utente.cognome);
      console.log('Luogo di nascita: ' + utente.luogoDiNascita);
      console.log('Sesso: ' + utente.sesso);
      console.log();
    });
  }

  mostraUtenti(): void {
    if(!this.mostraListaUtenti) {
      this.mostraListaUtenti = true;
    } else {
      this.mostraListaUtenti = false;
    }
  }

  eliminaUtente(index: number): void {
    this.repo.splice(index, 1);
  }

  mostraUtenteInput(index: number): void {
    this.utenteRegistrato = {
      nome : this.repo[index].nome,
      cognome : this.repo[index].cognome,
      luogoDiNascita : this.repo[index].luogoDiNascita,
      sesso : this.repo[index].sesso
    }
  }
}
