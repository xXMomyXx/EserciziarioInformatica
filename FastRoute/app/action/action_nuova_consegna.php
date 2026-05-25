<?php
global $pdo;
if (!isLoggedIn()) redirect('login');
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $stmt = $pdo->prepare("INSERT INTO mittenti (nome, cognome, indirizzo, telefono, email) VALUES (?,?,?,?,?)");
    $stmt->execute([$_POST['m_nome'], $_POST['m_cognome'], $_POST['m_indirizzo'], $_POST['m_telefono'], $_POST['m_email']]);
    $id_mittente = $pdo->lastInsertId();
    $stmt = $pdo->prepare("INSERT INTO destinatari (nome, cognome) VALUES (?,?)");
    $stmt->execute([$_POST['d_nome'], $_POST['d_cognome']]);
    $id_destinatario = $pdo->lastInsertId();
    $codice = $_POST['codice'];
    $id_sede_partenza = $_POST['id_sede_partenza'];
    $id_sede_arrivo = $_POST['id_sede_arrivo'];
    $data_acc = date('Y-m-d');
    $ora_acc = date('H:i:s');
    $operatore = $_SESSION['id_operatore'];
    $stmt = $pdo->prepare("INSERT INTO plichi (codice, id_mittente, id_destinatario, id_sede_partenza, id_sede_arrivo, data_accettazione, ora_accettazione, operatore_accettazione) VALUES (?,?,?,?,?,?,?,?)");
    $stmt->execute([$codice, $id_mittente, $id_destinatario, $id_sede_partenza, $id_sede_arrivo, $data_acc, $ora_acc, $operatore]);
    redirect('dashboard', 'Consegna registrata con successo.');
} else {
    redirect('nuova_consegna');
}