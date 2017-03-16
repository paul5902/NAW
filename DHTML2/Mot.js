var globalWord;
var modifiedWord;

function generateWords(theWord) {

var word = theWord;
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
var firstPart = modifiedWord.substring(0,idCurrent);
var secondPart = modifiedWord.substring(idToSwitchWith+1,globalWord.length);
var firstLetter = modifiedWord.charAt(idCurrent);
var secondLetter = modifiedWord.charAt(idToSwitchWith);
modifiedWord = firstPart + secondLetter + firstLetter + secondPart;

if(modifiedWord === globalWord) {
window.alert("VOUS AVEZ TROUVE LE MOT");
}

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

var firstPart = modifiedWord.substring(0,idToSwitchWith);
var secondPart = modifiedWord.substring(idCurrent+1,globalWord.length);
var firstLetter = modifiedWord.charAt(idToSwitchWith);
var secondLetter = modifiedWord.charAt(idCurrent);
modifiedWord = firstPart + secondLetter + firstLetter + secondPart;


if(modifiedWord === globalWord) {
window.alert("VOUS AVEZ TROUVE LE MOT");
}


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

function cleanWord() {
while (document.getElementById("letters").hasChildNodes()) {
    document.getElementById("letters").removeChild(document.getElementById("letters").firstChild);
}
while (document.getElementById("buttons").hasChildNodes()) {
    document.getElementById("buttons").removeChild(document.getElementById("buttons").firstChild);
}
}

function randomWord() {
var text = "";
var possible = "abcdefghijklmnopqrstuvwxyz";
for( var i=0; i < 5; i++ )
        text += possible.charAt(Math.floor(Math.random() * possible.length));
generateWords(text);
globalWord = text;

}

function randomize() {
window.alert(globalWord);
cleanWord();
var shuffled = globalWord.split('').sort(function(){return 0.5-Math.random()}).join('');
generateWords(shuffled);
modifiedWord = shuffled;

}


