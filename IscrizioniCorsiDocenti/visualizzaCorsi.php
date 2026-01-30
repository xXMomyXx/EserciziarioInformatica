<?php
$num = $_POST['num_corsi'];
$corsi = $_POST['corsi'];
$docenti = $_POST['docenti'];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Riepilogo</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Riepilogo Iscrizioni</h1>

<?php
if($num > 0) {
    echo "<table>";
    echo "<tr><th>Nome</th><th>Cognome</th><th>Corso</th></tr>";

    for($i = 0; $i < $num; $i++) {
        $corso = $corsi[$i];
        $doc = $docenti[$i];

        if(is_array($doc)) {
            foreach($doc as $d) {
                $parti = explode(" ", $d);
                $nome = $parti[0];
                $cognome = $parti[1];

                echo "<tr>";
                echo "<td>$nome</td>";
                echo "<td>$cognome</td>";
                echo "<td>$corso</td>";
                echo "</tr>";
            }
        }
    }

    echo "</table>";
} else {
    echo "<p>Nessun dato.</p>";
}
?>

<br>
<a href="index.php">Torna indietro</a>
</body>
</html>
