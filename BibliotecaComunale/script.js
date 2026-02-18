timeStr = document.getElementById("time")
dateStr = document.getElementById("date")
initialButton = document.getElementById("initialButton")
returnButton = document.getElementById("returnButton")
let now = new Date();
let msBeforeMidnight;
// Chiamata manuale alla funzione per evitare il delay iniziale di setTimeout
if (timeStr && dateStr){
    setAndUpdateTime();
    setAndUpdateDay();
}
if (initialButton) {
    initialButton.addEventListener("click", () => {
        window.location.href = "form.php";
    })
}
if (returnButton) {
    returnButton.addEventListener("click", () => {
        window.location.href = "index.php";
    })
}

function getCurrentTimeFormatted(now) { // Ritorna il tempo corrente come stringa formattata
    return aggiungiZero(now.getHours()) + ":" + aggiungiZero(now.getMinutes()) + ":" + aggiungiZero(now.getSeconds());
}

function getCurrentDayFormatted(now) { // Ritorna il giorno corrente come stringa formattata
    const months = ["Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno",
        "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"]
    const days = ["Domenica", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato"]

    return days[now.getDay()].toUpperCase() + " " + now.getDate() + " " + months[now.getMonth()].toUpperCase() + " " + now.getFullYear()
}

function aggiungiZero(n) { // Rende le ore, minuti e secondi con una sola unità aventi uno zero davanti. Es. 1:1:5 -> 01:01:05
    return String(n).padStart(2, "0")
}

// Siccome le date in JS sono rappresentate in millisecondi passati dal 1970, il tempo rimanente alla prossima mezzanotte
// si ottiene sottraendo dai ms di domani i ms attuali (tomorrow - now)
function getMsBeforeMidnight(now) {
    const tomorrow = new Date(now.getFullYear(), now.getMonth(), now.getDate() + 1)
    return tomorrow - now
}

//Funzione ricorsiva che imposta e aggiorna il giorno corrente ogni mezzanotte
function setAndUpdateDay() {
    const now = new Date()
    const msBeforeMidnight = getMsBeforeMidnight(now)
    dateStr.textContent = getCurrentDayFormatted(now);
    setTimeout(() => {
        setAndUpdateDay();
    }, msBeforeMidnight)
}

// Funzione ricorsiva che imposta e aggiorna il tempo corrente una volta ogni secondo
function setAndUpdateTime() {
    const now = new Date()
    timeStr.textContent = getCurrentTimeFormatted(now)
    setTimeout(() => {
        setAndUpdateTime()
    }, 1000)
}