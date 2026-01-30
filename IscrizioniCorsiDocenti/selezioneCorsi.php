<?php
$corsi = array("Sistemi e reti", "Robotica", "Contabilità", "Meccatronica", "Chimica",
    "Statistica", "Matematica", "Informatica", "Marketing", "Economia Politica");

$docenti = array("Piero Versari", "Mirko Dandi", "Filippo Marlotto", "Giovanni Gepparo",
    "Filippo Chirante", "Marco Dessì", "Enrico Pertoldi", "Sara Jane", "Maurizio Cordani", "Pietro Derzi");

$num = $_POST['num_corsi'];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Seleziona</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Seleziona Corsi e Docenti</h1>
<form method="POST" action="visualizzaCorsi.php">
    <input type="hidden" name="num_corsi" value="<?php echo $num; ?>">

    <?php for($i = 0; $i < $num; $i++) { ?>
        <div id="sezione">
            <h3>Corso <?php echo $i+1; ?></h3>

            <p>Scegli corso:</p>
            <select name="corsi[<?php echo $i; ?>]">
                <option value="">-- Scegli --</option>
                <?php
                foreach($corsi as $c) {
                    echo "<option value='$c'>$c</option>";
                }
                ?>
            </select>

            <p>Scegli docenti:</p>
            <select name="docenti[<?php echo $i; ?>][]" multiple>
                <?php
                foreach($docenti as $d) {
                    echo "<option value='$d'>$d</option>";
                }
                ?>
            </select>
        </div>
    <?php } ?>

    <br>
    <button type="submit">INVIA</button>
</form>
</body>
</html>
