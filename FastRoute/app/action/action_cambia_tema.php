<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['tema'])) {
    setcookie('tema', $_POST['tema'], time() + 3600 * 24 * 30, '/');
}
$referer = $_SERVER['HTTP_REFERER'] ?? 'index.php?page=dashboard';
header("Location: $referer");
exit;