<?php
function isLoggedIn() {
    return isset($_SESSION['id_operatore']);
}

function redirect($page, $message = null) {
    if ($message) {
        $_SESSION['message'] = $message;
    }
    header("Location: index.php?page=$page");
    exit;
}

function applicaTema() {
    $tema = isset($_COOKIE['tema']) ? $_COOKIE['tema'] : '#f4f4f4';

    if ($tema == '#2d2d2d') {
        echo '<style>
            body { background-color: #2d2d2d; color: #e0e0e0; }
            .container { background-color: #3a3a3a; color: #f0f0f0; border: 1px solid #555; }
            th { background-color: #4a4a4a; color: #fff; }
            td { border-color: #555; }
            a { color: #80b3ff; }
            input, select { background-color: #555; color: #fff; border-color: #777; }
        </style>';
    } else {
        echo '<style>body { background-color: ' . htmlspecialchars($tema) . '; }</style>';
    }
}

function inviaEmail($destinatario, $oggetto, $messaggio) {
    $headers = "From: noreply@fastroute.it\r\n";
    return mail($destinatario, $oggetto, $messaggio, $headers);
}
?>
