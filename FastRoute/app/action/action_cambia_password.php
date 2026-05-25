<?php
global $pdo;
if (!isLoggedIn()) redirect('login');
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $vecchia = $_POST['vecchia_password'];
    $nuova = $_POST['nuova_password'];
    $conferma = $_POST['conferma_password'];
    $id = $_SESSION['id_operatore'];
    $stmt = $pdo->prepare("SELECT password_hash FROM operatori WHERE id_operatore = ?");
    $stmt->execute([$id]);
    $hash = $stmt->fetchColumn();
    if (!password_verify($vecchia, $hash)) {
        redirect('cambia_password', 'Password attuale errata.');
    } elseif ($nuova !== $conferma) {
        redirect('cambia_password', 'Le nuove password non coincidono.');
    } elseif (!preg_match('/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[\W_]).{8,}$/', $nuova)) {
        redirect('cambia_password', 'La password deve avere almeno 8 caratteri, una maiuscola, una minuscola, un numero e un carattere speciale.');
    } else {
        $nuovo_hash = password_hash($nuova, PASSWORD_DEFAULT);
        $stmt = $pdo->prepare("UPDATE operatori SET password_hash = ?, primo_accesso = 0 WHERE id_operatore = ?");
        $stmt->execute([$nuovo_hash, $id]);
        $_SESSION['primo_accesso'] = 0;
        redirect('dashboard', 'Password cambiata con successo.');
    }
} else {
    redirect('cambia_password');
}