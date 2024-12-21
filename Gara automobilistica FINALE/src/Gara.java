import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static Utility.Tools.*;

public class Gara {
    private final String nome;
    private String nazione;
    private String vincitore;
    private int nSquadre;
    private final ArrayList<Scuderia> griglia;

    public Gara(String nome, String nazione) throws Exception {
        if (!Pilota.isValue(nome)) {
            throw new Exception("Il nome inserito nella gara non è valido");
        } else if (!Pilota.isValue(nazione)) {
            throw new Exception("La nazione inserita nella gara non è valida");
        }
        griglia = new ArrayList<>();
        this.nome = nome;
        this.nazione = nazione;
    }

    public String getNome() {
        return nome;
    }

    public String getNazione() {
        return nazione;
    }

    public String getVincitore() {
        return vincitore;
    }

    public int getnSquadre() {
        return nSquadre;
    }

    public void setnSquadre(int nSquadre) {
        this.nSquadre = nSquadre;
    }

    public ArrayList<Scuderia> getGriglia() {
        return griglia;
    }

    public void corriGara() throws Exception {
        if (nSquadre < 2) {
            throw new Exception("Sono necessari almeno 2 competitori per cominciare una gara. Numero attuale di competitori in questa gara: " + nSquadre);
        }
        Random rn = new Random();
        for (Scuderia scuderia : griglia) {
            scuderia.getTempoGiro().setStartTime(LocalTime.now());
            int waitTime = rn.nextInt(5000, 10000);
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < waitTime) {
                System.out.print("   -           __\n" +
                        " --          ~( @\\   \\\n" +
                        "---   _________]_[__/_>________\n" +
                        "     /  ____ \\ <>     |  ____  \\\n" +
                        "    =\\_/ __ \\_\\_______|_/ __ \\__D\n" +
                        "________(__)_____________(__)____");
                System.out.println();
                Wait(500);
            }
            System.out.println();
            scuderia.getTempoGiro().setEndTime(LocalTime.now());
            scuderia.getTempoGiro().impostaTempoGiroCronometro();
        }
        ordinaGara();
        impostaVincitore();
    }

    private void impostaVincitore() throws Exception {
        vincitore = griglia.getFirst().getnPilota().getNome() + " " + griglia.getFirst().getnPilota().getCognome();
    }

    private void ordinaGara() throws Exception {
        Collections.sort(griglia);
    }

    @Override
    public String toString() {
        return String.format("Nome gara: %s, Numero squadre: %d, Nazione: %s", nome, nSquadre, nazione);
    }
}
