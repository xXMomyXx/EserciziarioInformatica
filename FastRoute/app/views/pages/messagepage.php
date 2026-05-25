<h2>Messaggio</h2>
<p><?= htmlspecialchars($_SESSION['message'] ?? 'Nessun messaggio') ?></p>
<p><a href="index.php?page=login">Torna al login</a></p>