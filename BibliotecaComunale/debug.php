<?php
$nome = trim($_POST["nome"] ?? '');
$cognome = trim($_POST["cognome"] ?? '');
$basePwd = $_POST["pwd"] ?? '';

if ($nome === '' || $cognome === '' || $basePwd === '') {
    die("Tutti i campi sono obbligatori.");
}
$pwd = password_hash($basePwd,PASSWORD_DEFAULT);

$db = new PDO
("mysql:host=192.168.60.144;dbname=mohamed_guezam_lettori;charset=utf8mb4",
    "mohamed_guezam",
    "faciliterò.attui.",
    [PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_OBJ,
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION]
);

$query = "INSERT INTO lettori (nome, cognome, data_iscrizione, password) values (:nome, :cognome, now(), :password)";

try{
    $stmt = $db->prepare($query);
    $stmt->bindValue(":nome",$nome);
    $stmt->bindValue(":cognome",$nome);
    $stmt->bindValue(":password",$pwd);
    $stmt->execute();
    echo "Successful insert";
    $stmt->closeCursor();
} catch (PDOException $e){
    echo $e->getMessage();
}

$query = "SELECT * FROM lettori";

try{
    $stmt = $db->prepare($query);
    $stmt->execute();
    echo "<table>";
    echo "<tr>";
    echo "<th>ID</th>";
    echo "<th>Nome</th>";
    echo "<th>Cognome</th>";
    echo "<th>Data iscrizione</th>";
    echo "</tr>";
    while ($user = $stmt->fetch()){
        echo "<tr>";
        echo "<td>" . $user->id . "</td>";
        echo "<td>" . $user->nome . "</td>";
        echo "<td>" . $user->cognome . "</td>";
        echo "<td>" . $user->data_iscrizione . "</td>";
        echo "<tr>";
    }
    echo "</table>";
    $stmt->closeCursor();
} catch (PDOException $e){
    echo $e->getMessage();
}
?>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <title>DEBUG</title>
</head>
<body>
<button id="returnButton">Ritorna alla pagina di registrazione</button>
</body>
<script src="script.js"></script>
</html>
