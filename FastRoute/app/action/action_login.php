<?php
global $pdo;
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'];
    $password = $_POST['password'];
    $stmt = $pdo->prepare("SELECT * FROM operatori WHERE email = ?");
    $stmt->execute([$email]);
    $op = $stmt->fetch();
    if ($op && password_verify($password, $op['password_hash'])) {
        $_SESSION['id_operatore'] = $op['id_operatore'];
        $_SESSION['primo_accesso'] = $op['primo_accesso'];
        if ($op['primo_accesso']) {
            redirect('cambia_password', 'Devi cambiare la password al primo accesso.');
        } else {
            redirect('dashboard', 'Login effettuato.');
        }
    } else {
        redirect('login', 'Email o password errati.');
    }
} else {
    redirect('login');
}