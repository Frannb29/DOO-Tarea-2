package modelo;
import java.time.Instant;
public class Retraso extends Asistencia {
    private Instant horaRetraso;
    public Retraso(Invitable invitable, Instant horaRetraso){
        super(invitable);
        this.horaRetraso = horaRetraso;
    }
    public Instant getHoraRetraso(){
        return horaRetraso;
    }
    public void setHora(Instant horaRetraso){
        this.horaRetraso = horaRetraso;
    }
    @Override
    public String toString() {
        return super.toString() + " | Hora de llegada: " + horaRetraso;
    }
}
