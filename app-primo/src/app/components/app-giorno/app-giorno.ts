import { Component, input } from '@angular/core';
import { FormsModule } from '@angular/forms';

export interface Utente {
  nome: string;
  cognome: string;
  luogoDiNascita: string;
  sesso: string;
}

@Component({
  selector: 'app-app-giorno',
  imports: [FormsModule],
  templateUrl: './app-giorno.html',
  styleUrl: './app-giorno.css',
})

export class AppGiorno {
  repo: Utente[] = [];
  giorni: string[] = ['Lunedì', 'Martedì', 'Mercoledì', 'Giovedì', 'Venerdì', 'Sabato', 'Domenica'];
  i: number = 0;
  giorno: string = this.giorni[this.i++];
  nome: string = '';
  cognome: string = '';
  luogoDiNascita: string = '';
  sesso: string = '';
  utenteRegistrato?: Utente;
  mostraListaUtenti: boolean = false;


  cambiaGiorno(): void {
    if (this.i > 6) {
      this.i = 0;
    }
    this.giorno = this.giorni[this.i++];
  }

  salva(nome: string, cognome: string, luogoDiNascita: string, sesso: string): void {
    this.nome = nome;
    this.cognome = cognome;
    this.luogoDiNascita = luogoDiNascita;
    this.sesso = sesso
  }

  cancella(nome: string, cognome: string, luogoDiNascita: string, sesso: string): void {
    this.nome = nome;
    this.cognome = cognome;
    this.luogoDiNascita = luogoDiNascita;
    this.sesso = sesso;
  }

  salvaUtente(utente: Utente): void {
    this.utenteRegistrato = utente;
    this.repo.push(this.utenteRegistrato);
    this.stampaUtente();
  }

  stampaUtente(): void {
    this.repo.forEach(utente => {
      console.log('Nome: ' + utente.nome);
      console.log('Cognome: ' + utente.cognome);
      console.log('Luogo di nascita: ' + utente.luogoDiNascita);
      console.log('Sesso: ' + utente.sesso);
      console.log();
    });
  }

  cancellaUtente(): void {
    this.utenteRegistrato = undefined;
    this.repo.pop();
  }

  mostraUtenti(): void {
    if(!this.mostraListaUtenti) {
      this.mostraListaUtenti = true;
    } else {
      this.mostraListaUtenti = false;
    }
  }
}
