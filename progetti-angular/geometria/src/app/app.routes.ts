import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Inserimento } from './components/inserimento/inserimento';
import { Elenco } from './components/elenco/elenco';
import { Contatti } from './components/contatti/contatti';
import { AreaRiservata } from './components/area-riservata/area-riservata';
import { Profilo } from './components/area-riservata/profilo/profilo';
import { Impostazioni } from './components/area-riservata/impostazioni/impostazioni';
import { Quadrato } from './components/geometria/quadrato/quadrato';
import path from 'path';
import { Triangolo } from './components/geometria/triangolo/triangolo';
import { Rettangolo } from './components/geometria/rettangolo/rettangolo';
import { GeometriaApp } from './components/geometria-app/geometria-app';

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
    {
        path: 'geometria', component: GeometriaApp
        /*
        children: [
            {path: 'quadrato', component: Quadrato},
            {path: 'triangolo', component: Triangolo},
            {path: 'rettangolo', component: Rettangolo},
            {path: '', redirectTo: 'quadrato', pathMatch: 'full'}
        ]*/
    },
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: '**', redirectTo: 'home' }
];
