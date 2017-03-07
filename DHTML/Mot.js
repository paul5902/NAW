function generateWords() {

var word = document.getElementById("word").value;
for (var i = 0; i < word.length; i++) {

//Création de la TD qui accueillera la lettre

var td = document.createElement("td");
td.setAttribute("id","tdlettre"+i);
document.getElementById("letters").appendChild(td);

var td2 = document.createElement("td");
td2.setAttribute("id","tdbuttons"+i);
document.getElementById("buttons").appendChild(td2);

//Création de l'image

var img = document.createElement("img");
img.src = "Lettres/"+word.charAt(i)+".jpg";
img.setAttribute("id","img"+word.charAt(i));
img.width=60;
img.height=60;
document.getElementById("tdlettre"+i).appendChild(img);

// Création bouton en dessous de chaque image

var element = document.createElement("input");
element.setAttribute("type","button");
element.setAttribute("value",">");
element.setAttribute("name",word.charAt(i));
element.setAttribute("onclick","permutationDroite("+i+","+(i+1)+")");

var element2 = document.createElement("input");
element2.setAttribute("type","button");
element2.setAttribute("value","<");
element2.setAttribute("onclick","permutationGauche("+i+","+(i-1)+")");

document.getElementById("tdbuttons"+i).appendChild(element2);
document.getElementById("tdbuttons"+i).appendChild(element);

}

}

function permutationDroite(idCurrent,idToSwitchWith) {

var caseLettreGauche = "tdlettre"+idCurrent;
var caseLettreDroite = "tdlettre"+idToSwitchWith; 

var lettreGauche = document.getElementById(caseLettreGauche).firstChild;
var lettreDroite = document.getElementById(caseLettreDroite).firstChild;

while (document.getElementById(caseLettreGauche).hasChildNodes()) {
    document.getElementById(caseLettreGauche).removeChild(document.getElementById(caseLettreGauche).firstChild);
}
document.getElementById(caseLettreGauche).appendChild(lettreDroite);

while (document.getElementById(caseLettreDroite).hasChildNodes()) {
    document.getElementById(caseLettreDroite).removeChild(document.getElementById(caseLettreDroite).firstChild);
}

document.getElementById(caseLettreDroite).appendChild(lettreGauche);


}

function permutationGauche(idCurrent,idToSwitchWith) {

var caseLettreGauche = "tdlettre"+idToSwitchWith;
var caseLettreDroite = "tdlettre"+idCurrent; 

var lettreGauche = document.getElementById(caseLettreGauche).firstChild;
var lettreDroite = document.getElementById(caseLettreDroite).firstChild;

while (document.getElementById(caseLettreGauche).hasChildNodes()) {
    document.getElementById(caseLettreGauche).removeChild(document.getElementById(caseLettreGauche).firstChild);
}
document.getElementById(caseLettreGauche).appendChild(lettreDroite);

while (document.getElementById(caseLettreDroite).hasChildNodes()) {
    document.getElementById(caseLettreDroite).removeChild(document.getElementById(caseLettreDroite).firstChild);
}

document.getElementById(caseLettreDroite).appendChild(lettreGauche);

}

function cleanScreen() {

document.location.reload();

}


