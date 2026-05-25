<h2>Benvenuti su FastRoute</h2>
<p>Servizio di corriere espresso affidabile e veloce.</p>

<h3>Richiedi informazioni</h3>
<?php if (isset($_SESSION['message'])): ?>
    <div class="message"><?= htmlspecialchars($_SESSION['message']) ?></div>
    <?php unset($_SESSION['message']); ?>
<?php endif; ?>
<form action="index.php?action=richiesta" method="post">
    <input type="text" name="nome" placeholder="Nome" required><br>
    <input type="email" name="email" placeholder="Email" required><br>
    <textarea name="messaggio" placeholder="Messaggio" rows="4" required></textarea><br>
    <button type="submit">Invia richiesta</button>
</form>
<p><a href="index.php?page=login">Area personale (operatori)</a></p>