import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

export interface Attivita {
  id: number,
  nomeAttivita: string,
  giorno: Date,
  priorita: number,
  completed: boolean
}

@Component({
  selector: 'app-gestione-attivita',
  imports: [FormsModule, CommonModule],
  templateUrl: './gestione-attivita.html',
  styleUrl: './gestione-attivita.css',
})
export class GestioneAttivita {
  id: number = 0;
  nomeAttivita: string = "";
  giorno?: Date;
  priorita: number = 1;
  listaAttivita: Attivita[] = [];

  aggiungiAttivita() {
    this.id++;
    this.giorno = new Date();
    let attivita: Attivita = {
      id: this.id,
      nomeAttivita: this.nomeAttivita,
      giorno: this.giorno,
      priorita: this.priorita,
      completed: false
    }
    this.listaAttivita.push(attivita);
  }

  attivitaCompletata(index: number) {
    /*
    if (this.listaAttivita[index].completed) { 
      this.listaAttivita[index].completed = false;
    } else {
      this.listaAttivita[index].completed = true;
    }*/
    this.listaAttivita[index].completed = !this.listaAttivita[index].completed;
  }

  eliminaAttivita(index: number) {
    this.listaAttivita.splice(index, 1);
  }

  spostaSu(index: number) {
    if (index == 0) {
      return;
    }
    let temp = this.listaAttivita[index - 1];
    this.listaAttivita[index - 1] = this.listaAttivita[index];
    this.listaAttivita[index] = temp;
  }

  spostaGiu(index: number) {
    if (index >= this.listaAttivita.length - 1) {
      return;
    }
    let temp = this.listaAttivita[index + 1];
    this.listaAttivita[index + 1] = this.listaAttivita[index];
    this.listaAttivita[index] = temp;
  }

  ordinaPerNome() {
    this.listaAttivita.sort((a, b) =>
      a.nomeAttivita.localeCompare(b.nomeAttivita)
    );
  }

  ordinaPerId() {
    this.listaAttivita.sort((a, b) =>
      a.id - b.id
    );
  }

  ordinaPriorita() {
    this.listaAttivita.sort((a, b) =>
      b.priorita - a.priorita
    );
  }

  ordinaPiuRecente() {
    this.listaAttivita.sort((a, b) =>
      b.giorno.getTime() - a.giorno.getTime()
    );
  }

  pulisciLista() {
    this.listaAttivita = [];
  }
}
