import javax.swing.*;

public class Cronometro {
    private Timer timer;
    private int contatore = 0;
    private boolean on = false; //Flag per indicare se il cronometro sta contando o meno

    public Cronometro() {
        timer = new Timer(1000, e -> {
            if (on) {
                contatore++;
                System.out.println(contatore);
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

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void iniziaCronometro() {
        on = true;
        timer.start();
    }

    public void fermaCronometro() {
        on = false;
    }
}
