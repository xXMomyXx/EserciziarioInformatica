import javax.swing.*;

public class CronometroGara {
    //Utilizziamo la classe Timer per creare un cronometro poiché fornisce
    // svariati metodi che ne simulano il funzionamento.
    private Timer timer;
    private int contatore = 0;

    public CronometroGara(Gara g) {
        //Utilizziamo il costruttore della classe 'Timer' che riceve come primo parametro
        //il 'delay', ovvero la cadenza con cui svolge l'azione specificata nel secondo parametro
        //'ActionEvent', espresso con una lambda che nel nostro caso incrementa ogni secondo la
        //'distanzaPercorsa' di ogni auto nella lista della sua 'cilindrata'.
        timer = new Timer(1000, e -> {
            contatore++;
            for (Auto auto1 : g.getCollezioneAuto()) {
                auto1.setDistanzaPercorsa(auto1.getDistanzaPercorsa() + auto1.getCilindrata());
            }
        });
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getContatore() {
        return contatore;
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    public void iniziaCronometro() {
        timer.start();
    }

    public void fermaCronometro() {
        timer.stop();
    }
}