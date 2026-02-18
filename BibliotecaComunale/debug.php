<?php
    $nome = isset($_POST['nome']) ? $_POST['nome'] : null;
    $cognome = isset($_POST['cognome']) ? $_POST['cognome'] : null;
    if ($nome && $cognome) {
        //Utilizziamo un file di testo per tenere conto del numero degli utenti registrati
        $counter = file_get_contents("counter.txt");
        $counter++;
        date_default_timezone_set("Europe/Rome");
        $date = date("d-m-Y H:i:s");
        //Utilizziamo un file di testo per salvare i dati degli utenti
        file_put_contents("userInfo.txt", "Nome: ".$nome."\n".
                "Cognome: ".$cognome."\n"."Numero: ".$counter."\n"."Data registrazione: ".$date."\n", FILE_APPEND);
        file_put_contents("counter.txt", $counter);
        // Rimando l'utente sulla pagina stessa nuovamente al fine di svuotare i dati in POST ed evitare che ricaricando
        // la pagina possano essere immessi nuovamente i medesimi dati
        header("Location: ".$_SERVER['PHP_SELF']);
        exit();
    }
    $users = file("userInfo.txt", FILE_IGNORE_NEW_LINES); //Ogni riga del txt diventa un elemento dell'array
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
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Numero</th>
            <th>Data registrazione</th>
        </tr>
        <?php
            for ($i = 0; $i < count($users); $i += 4) { //Iteriamo di 4 righe alla volta poiché ogni utente ha 4 righe di dati
                echo "<tr>";
                echo "<td>" . explode(": ", $users[$i])[1] . "</td>";
                echo "<td>" . explode(": ", $users[$i+1])[1] . "</td>";
                echo "<td>" . explode(": ", $users[$i+2])[1] . "</td>";
                echo "<td>" . explode(": ", $users[$i+3])[1] . "</td>";
                echo "</tr>";
            }
        ?>
    </table>
    <button id="returnButton">Ritorna alla pagina di registrazione</button>
</body>
<script src = "script.js"></script>
</html>
