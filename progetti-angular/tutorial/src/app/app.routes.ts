import { Routes } from '@angular/router';
import { Inserimento } from './prodotti/inserimento/inserimento';
import { Elenco } from './prodotti/elenco/elenco';
import { Home } from './home/home';
import { Contatti } from './contatti/contatti';
import { AreaRiservata } from './area-riservata/area-riservata';
import { Profilo } from './area-riservata/profilo/profilo';
import { Impostazioni } from './area-riservata/impostazioni/impostazioni';

export const routes: Routes = [
    { path: 'home', component: Home },
    {
        path: 'prodotti',
        children: [
            { path: 'inserimento', component: Inserimento },
            { path: 'elenco', component: Elenco },
            { path: '', redirectTo: 'elenco', pathMatch: 'full' }
        ]
    },

    { path: 'contatti', component: Contatti },

    
    {
        path: 'area-riservata', component: AreaRiservata, // <-- Il "guscio" fisso con la sidebar
        children: [
            { path: 'profilo', component: Profilo }, // URL: area-riservata/profilo
            { path: 'impostazioni', component: Impostazioni }, // URL: area-riservata/impostazioni
            // Se l'utente va su /area-riservata lo dirottiamo subito su profilo
            { path: '', redirectTo: 'profilo', pathMatch: 'full' }
        ]
    },
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: '**', redirectTo: 'home' }
];
