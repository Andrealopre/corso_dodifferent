import { Injectable } from '@angular/core';

export interface Utente {
  id : number
  nome : string
  cognome : string
  luogoDiNascita : string
  dataDiNascita : Date
  sesso : String
  titoloDiStudio : string
  codiceFiscale : string
}

@Injectable({
    providedIn: 'root'
})
export class PersonaService {
    private repoPersona: Utente[] = [];

    //read-all
    getPersone(): Utente[] {
        return this.repoPersona;
    }

    //read-entità (id)

    //update (id - nome?)

    //create
    aggiungiPersona(persona: Utente) {
        this.repoPersona.push(persona);
    }

    //delete
    eliminaUtente(index: number) {
        this.repoPersona.splice(index, 1);
    }
}
