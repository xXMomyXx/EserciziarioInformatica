<?php
global $pdo;
require_once __DIR__ . '/../../config/requireconfig.php';
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

if (!isLoggedIn()) redirect('login');
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $codice = $_POST['codice'];
    $operatore = $_SESSION['id_operatore'];
    $data = date('Y-m-d');
    $ora = date('H:i:s');

    $stmt = $pdo->prepare("UPDATE plichi SET data_ritiro = ?, ora_ritiro = ?, operatore_ritiro = ? WHERE codice = ? AND data_spedizione IS NOT NULL AND data_ritiro IS NULL");
    $stmt->execute([$data, $ora, $operatore, $codice]);

    if ($stmt->rowCount() > 0) {
        // Recupera email mittente
        $stmt2 = $pdo->prepare("SELECT m.email FROM plichi p JOIN mittenti m ON p.id_mittente = m.id_mittente WHERE p.codice = ?");
        $stmt2->execute([$codice]);
        $email = $stmt2->fetchColumn();

        if ($email) {
            $mail = new PHPMailer(true);
            try {
                $mail->isSMTP();
                $mail->Host       = SMTP_HOST;
                $mail->SMTPAuth   = true;
                $mail->Username   = SMTP_USER;
                $mail->Password   = SMTP_PASS;
                $mail->SMTPSecure = SMTP_SECURE;
                $mail->Port       = SMTP_PORT;
                $mail->setFrom(MAIL_FROM, MAIL_FROM_NAME);
                $mail->addAddress($email);
                $mail->Subject = 'Conferma ritiro plico ' . $codice;
                $mail->Body    = "Gentile cliente,\n\nIl tuo plico con codice $codice è stato ritirato il $data alle $ora.\n\nGrazie per aver scelto FastRoute.";
                $mail->send();
                redirect('dashboard', 'Ritiro registrato. Email inviata al mittente.');
            } catch (Exception $e) {
                redirect('dashboard', 'Ritiro registrato, ma email non inviata: ' . $mail->ErrorInfo);
            }
        } else {
            redirect('dashboard', 'Ritiro registrato, ma email del mittente non trovata.');
        }
    } else {
        redirect('registra_ritiro', 'Plico non trovato, non spedito o già ritirato.');
    }
} else {
    redirect('registra_ritiro');
}
?>