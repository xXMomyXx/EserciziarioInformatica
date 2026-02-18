<?php
?>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <title>ISCRIZIONE</title>
</head>
<body>
    <form method="POST" action="debug.php">
        <div class="header">
            <h1 class = title>REGISTRAZIONE</h1>
            <label for="nome">Nome:</label> <input id = "nome" type="text" name="nome" required><br>
            <label for="cognome">Cognome:</label> <input id = "cognome" type="text" name="cognome" required><br>
            <label for="pwd">Password:</label> <input id="pwd" type="password" name="pwd" required><br>
            <button type="submit" id="regButton">REGISTRATI</button>
        </div>
    </form>
</body>
<script src = "script.js"></script>
</html>
