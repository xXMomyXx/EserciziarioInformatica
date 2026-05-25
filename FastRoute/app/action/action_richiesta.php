<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    global $pdo;
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $messaggio = $_POST['messaggio'];
    $stmt = $pdo->prepare("INSERT INTO richiesta (nome, email, messaggio) VALUES (?, ?, ?)");
    $stmt->execute([$nome, $email, $messaggio]);
    $_SESSION['message'] = "Richiesta inviata con successo. Ti risponderemo presto.";
    header('Location: index.php?page=home');
    exit;
} else {
    header('Location: index.php?page=home');
    exit;
}