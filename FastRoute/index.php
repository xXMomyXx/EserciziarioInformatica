<?php
require 'config/requireconfig.php';
session_start();
require_once 'app/functions/utilities.php';

$page = $_GET['page'] ?? 'home';
$action = $_GET['action'] ?? '';

if ($action) {
    $actionFile = "app/action/action_$action.php";
    if (file_exists($actionFile)) {
        require $actionFile;
    } else {
        $_SESSION['message'] = "Azione non trovata.";
        header('Location: index.php?page=messagepage');
        exit;
    }
} else {
    $viewFile = "app/views/pages/$page.php";
    if (file_exists($viewFile)) {
        require "app/views/layouts/header.php";
        require $viewFile;
        require "app/views/layouts/footer.php";
    } else {
        $_SESSION['message'] = "Pagina non trovata.";
        header('Location: index.php?page=messagepage');
        exit;
    }
}
?>