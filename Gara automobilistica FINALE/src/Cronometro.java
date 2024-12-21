import java.time.LocalTime;

public class Cronometro implements Comparable<Cronometro> {
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer tempoGiroCronometro;

    public Cronometro() {
        startTime = LocalTime.now();
        endTime = LocalTime.now();
        tempoGiroCronometro = startTime.toSecondOfDay() - endTime.toSecondOfDay();
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getTempoGiroCronometro() {
        return tempoGiroCronometro;
    }

    public void impostaTempoGiroCronometro() throws Exception {
        if (endTime.toSecondOfDay() - startTime.toSecondOfDay() == 0) {
            throw new Exception("Lunghezza giro non valida");
        }
        tempoGiroCronometro = endTime.toSecondOfDay() - startTime.toSecondOfDay();
    }

    @Override
    public int compareTo(Cronometro o) {
        return tempoGiroCronometro.compareTo(o.tempoGiroCronometro);
    }
}
