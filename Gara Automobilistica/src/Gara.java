import java.util.ArrayList;

public class Gara {
    private String nomeGara;
    private String risultato;
    private ArrayList<Auto> collezioneAuto;
    private int lunghezzaStrada;

    public Gara(String nomeGara, ArrayList<Auto> collezioneAuto, int lunghezzaStrada) {
        this.nomeGara = nomeGara;
        this.collezioneAuto = collezioneAuto;
        this.lunghezzaStrada = lunghezzaStrada;
    }

    public String getNomeGara() {
        return nomeGara;
    }

    public void setNomeGara(String nomeGara) {
        this.nomeGara = nomeGara;
    }

    public String getRisultato() throws Exception {
        //Dovesse il consumatore cercare di richidere il risultato prima che
        //la gara sia stata effettivamente svolta, lanciamo un'eccezione.
        if (risultato == null) {
            throw new Exception("Le auto non hanno ancora gareggiato");
        }
        return risultato;
    }

    public void setRisultato(String risultato) {
        this.risultato = risultato;
    }

    public ArrayList<Auto> getCollezioneAuto() {
        return collezioneAuto;
    }

    public void setCollezioneAuto(ArrayList<Auto> collezioneAuto) {
        this.collezioneAuto = collezioneAuto;
    }

    public int getLunghezzaStrada() {
        return lunghezzaStrada;
    }

    public void setLunghezzaStrada(int lunghezzaStrada) {
        this.lunghezzaStrada = lunghezzaStrada;
    }

    public void corriGara() throws Exception {
        //Dovesse essere chiamato questo metodo con nessuna auto
        //nella lista di automobili, lanciamo un'eccezione.
        if (collezioneAuto == null || collezioneAuto.isEmpty()) {
            throw new Exception("Non vi sono auto per gareggiare");
        }
        boolean finito = false;
        //Inizializziamo un oggetto 'CronometroGara' con parametro 'this',
        //perché abbia effetto sulla gara che chiama il metodo. Inoltre
        //chiamiamo il metodo 'iniziaCronometro' affinché questo cominci
        //a misurare il tempo dal momento in cui è chiamato.
        CronometroGara cr = new CronometroGara(this);
        cr.iniziaCronometro();
        //Iteriamo finché la condizione 'finito' non diventa vera. Questa diventa tale soltanto se 'distanzaPercorsa' di uno dei veicoli
        //(attraverso i quali iteriamo con un for-each) è superiore a 'lunghezzaStrada', e dunque ha completato la gara.
        //Una volta che uno dei veicoli ha completato la gara, settiamo 'risultato' con il tempo in cui il vincitore ha
        //completato la gara e il nome e cognome di questo. Usiamo inoltre 'break' al fine di evitare ulteriori iterazioni
        //inutili del for-each.
        while (!finito) {
            for (Auto auto : collezioneAuto) {
                if (auto.getDistanzaPercorsa() >= lunghezzaStrada) {
                    cr.fermaCronometro();
                    this.setRisultato("La gara è stata vinta in " + cr.getContatore() + " secondi da " + auto.getPilota().getNome() + " " + auto.getPilota().getCognome());
                    finito = true;
                    break;
                }
            }
        }
    }
}
