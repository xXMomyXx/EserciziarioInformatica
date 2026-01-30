<!DOCTYPE html>
<html lang="en">
<head>
    <title>Corsi Docenti</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>App Iscrizione Docenti corsi</h1>
<form method="POST" action="selezioneCorsi.php">
    <p>A quanti corsi ti vuoi iscrivere (MAX 10)?</p>
    <input type="number" name="num_corsi" min="1" max="10" required>
    <br><br>
    <button type="submit">AVANTI</button>
</form>
</body>
</html>
