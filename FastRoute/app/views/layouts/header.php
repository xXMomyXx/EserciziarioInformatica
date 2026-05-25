<?php
require_once __DIR__ . '/../../../app/functions/utilities.php';
$tema_attuale = isset($_COOKIE['tema']) ? $_COOKIE['tema'] : '#ffffff';
?>
<!DOCTYPE html>
<html>
<head>
    <title><?= SITE_NAME ?></title>
    <link rel="stylesheet" href="public/css/mystyle.css">
    <?php applicaTema(); ?>
</head>
<body>
<div class="container">
    <h1><?= SITE_NAME ?></h1>
    <?php if (isLoggedIn()): ?>
        <div class="menu">
            <a href="index.php?page=dashboard">Dashboard</a> |
            <a href="index.php?page=nuova_consegna">Nuova consegna</a> |
            <a href="index.php?page=registra_spedizione">Registra spedizione</a> |
            <a href="index.php?page=registra_ritiro">Registra ritiro</a> |
            <a href="index.php?page=verifica_stato">Verifica stato</a> |
            <a href="index.php?page=statistiche">Statistiche</a> |
            <a href="index.php?page=cambia_password">Cambia password</a> |
            <a href="index.php?action=logout">Logout</a>
            <form method="post" action="index.php?action=cambia_tema" style="display:inline; float:right;">
                <select name="tema" onchange="this.form.submit()">
                    <option value="#ffffff" <?= $tema_attuale == '#ffffff' ? 'selected' : '' ?>>Chiaro</option>
                    <option value="#d9ead3" <?= $tema_attuale == '#d9ead3' ? 'selected' : '' ?>>Verde</option>
                    <option value="#ffe6e6" <?= $tema_attuale == '#ffe6e6' ? 'selected' : '' ?>>Rosa</option>
                    <option value="#2d2d2d" <?= $tema_attuale == '#2d2d2d' ? 'selected' : '' ?>>Scuro</option>
                </select>
            </form>
        </div>
        <hr>
    <?php endif; ?>
    <?php if (isset($_SESSION['message'])): ?>
        <div class="message"><?= htmlspecialchars($_SESSION['message']) ?></div>
        <?php unset($_SESSION['message']); ?>
    <?php endif; ?>