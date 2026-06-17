import { Component, ElementRef, ViewChild } from '@angular/core';
import { NgStyle } from '@angular/common';

export enum BCK { black, white, red, green, blue, pink, yellow, orange };

@Component({
  selector: 'app-stile',
  imports: [NgStyle],
  templateUrl: './stile.html',
  styleUrl: './stile.css',
})
export class Stile {
  colore: string = 'black';
  background_color: string = 'white';
  larghezza: string = '200px';
  size: string = '16px';
  

  @ViewChild('fontsize') fontsizeInput!: ElementRef<HTMLInputElement>;
  font_dim=Number(this.size.slice(0, 2))

  getColoreCasuale() {
    let cifraEsa = '0123456789ABCDEF'.split('')
    let colore_app: string = '#'
    for (var i = 0; i < 6; i++) {
      colore_app += cifraEsa[Math.floor(Math.random() * 16)]
    }
    this.colore = colore_app
  }

  getBCK() {
    let font_dim = Number(this.size.slice(0, 2))
    font_dim = font_dim * 3
    this.larghezza = String(font_dim) + "px"
    this.background_color = BCK[1 + (Math.floor(Math.random() * 8))]
  }

  getSize(inc: number) {
    let font_dim: number = parseInt(this.size)
    if (inc > 0) {
      if (font_dim < 65)
        font_dim += inc;
    } else {
      if (font_dim > 12) {
        font_dim += inc;
      }
    }
    this.size = font_dim + "px"
    font_dim = font_dim * 3
    this.larghezza = String(font_dim) + "px"
  }

  


  ngAfterViewInit() {
    this.size = "18px"
  }

  getValore() {
    let font_dim: number = parseInt(this.size)
    font_dim = font_dim * 3
    this.larghezza = String(font_dim) + "px"
  }
}
