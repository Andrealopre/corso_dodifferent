import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-pipe',
    templateUrl: './pipe.component.html',
    styleUrls: ['./pipe.component.css']
})
export class PipeComponent implements OnInit {
    title = 'app-prova';
    num1: number = 12.38343844848484;
    num2 = 0.5;
    num3: number = 2.5;
    num4: number = 0.5;
    myStr: any = "Televisione";
    objDate: Date = new Date(Date.now())
    numDate: number = 147896544151;
    strDate = 'Mon Nov 07 2016 09:44:12 GMT+0530';
    infoData: string = "";
    villaggio = { nome: 'sole e mare', citta: 'Tropea' }
    setData(info: string) { this.infoData = info };
    infoData2: string = "";
    villaggio2 = { nome2: 'sole e mare', citta2: 'Tropea' }
    setData2(info: string) { this.infoData2 = info };
    constructor() { }
}