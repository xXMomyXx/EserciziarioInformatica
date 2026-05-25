<?php
global $pdo;
if (!isLoggedIn()) redirect('login');
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $codice = $_POST['codice'];
    $operatore = $_SESSION['id_operatore'];
    $data = date('Y-m-d');
    $ora = date('H:i:s');
    $stmt = $pdo->prepare("UPDATE plichi SET data_spedizione = ?, ora_spedizione = ?, operatore_spedizione = ? WHERE codice = ? AND data_spedizione IS NULL");
    $stmt->execute([$data, $ora, $operatore, $codice]);
    if ($stmt->rowCount() > 0) {
        redirect('dashboard', 'Spedizione registrata.');
    } else {
        redirect('registra_spedizione', 'Plico non trovato o già spedito.');
    }
} else {
    redirect('registra_spedizione');
}