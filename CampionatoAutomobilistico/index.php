<?php
?>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel = "stylesheet" href = "css/style.css">
    <title>Campionato automobilistico</title>
</head>
<body>
    <form method="post" target="elab.php">
        <div class="header">
            <label for="nameBox">NOME </label><input id="nameBox" type="text" name="nome" required>
            <label for="surnameBox">COGNOME </label><input id="surnameBox" type="text" name="cognome" required>
            <label for="nationalityBox">NAZIONALITA'  </label><input id="nationalityBox" type="text" name="cognome" required>
            <label for="phoneNumberBox">CELLULARE </label><input id="phoneNumberBox" type="tel" name="cognome" required>
        </div>
    </form>
</body>
</html>
