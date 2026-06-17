import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Registrazione } from './components/registrazione/registrazione';
import { Elenco } from './components/elenco/elenco';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full'},
    { path: 'home', component: Home},
    { path: 'registrazione', component: Registrazione},
    { path: 'elenco', component: Elenco}
];
