const { createElement } = require("react");

function ingrandisci() {
    const testo = document.getElementById("testo1");
    let dimensione = parseInt(window.getComputedStyle(testo).fontSize);
    testo.style.fontSize = dimensione + 1 + "px";
}

function diminuisci() {
    const testo = document.getElementById("testo1");
    let dimensione = parseInt(window.getComputedStyle(testo).fontSize);
    testo.style.fontSize = dimensione - 1 + "px";
}

function spostaBlocco() {
    event.stopPropagation()
    const blocco = document.getElementById("box");
    let margine = parseInt(window.getComputedStyle(blocco).marginLeft);
    blocco.style.transition = "0.35s ease-in";
    blocco.style.marginLeft = margine + 20 + "px"

}

function resettaBlocco(event) {
    const blocco = document.getElementById("box");
    blocco.style.transition = "0.35s ease-in";
    blocco.style.marginLeft = "5px";
}

function mostraScatolo() {
    const scatolo = document.getElementById("scatolo");
    scatolo.classList.toggle("hidden");
}

function testEta() {
    const nome = document.querySelector("#input_nome").value;
    const cognome = document.querySelector("#input_cognome").value;
    const eta = document.querySelector("#input_eta").value;
    let risultato = document.querySelector("#risultato");

    risultato.innerHTML = "";
    if (eta > 17) {
        risultato.innerHTML += nome + " " + cognome + " è maggiorenne!";
    } else {
        risultato.innerHTML += nome + " " + cognome + " è minorenne!";
    }
}

function resetta() {
    const bloccoBlu = document.querySelector(".box_blue");
    const bloccoVerde = document.querySelector(".box_green");
    bloccoBlu.style.backgroundColor = "blue";
    bloccoVerde.style.backgroundColor = "green";
}

function cambiaVerde() {
    const blocco = document.querySelector(".box_green");
    blocco.style.backgroundColor = "yellow";
}

function cambiaBlu() {
    const blocco = document.querySelector(".box_blue");
    blocco.style.backgroundColor = "magenta";
}

function cancellaPalle() {
    const padre = document.getElementById("div_padre");
    const audioPlayer = document.getElementById("audioPlayer");

    audioPlayer.play();
    padre.innerHTML = "";
}

function aggiungi(tipoPalla) {
    const padre = document.getElementById("div_padre");
    const figlio = document.createElement("div");

    figlio.style.width = "100px";
    figlio.style.height = "100px";
    figlio.style.borderRadius = "50px";

    if (tipoPalla == "palla1") {
        figlio.style.backgroundColor = "red";
    }

    if (tipoPalla == "palla2") {
        figlio.style.backgroundColor = "blue";
    }

    if (tipoPalla == "palla3") {
        figlio.style.backgroundColor = "green";
    }

    padre.appendChild(figlio);
}