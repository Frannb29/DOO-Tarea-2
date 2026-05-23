package modelo;
import java.time.Instant;

/**
 * Clase que representa una asistencia con retraso.
 */
public class Retraso extends Asistencia {
    private Instant horaRetraso;

    /**
     * Crea un registro de retraso para un invitado.
     *
     * @param invitable participante que llego tarde
     * @param horaRetraso instante de llegada tardia
     */
    public Retraso(Invitable invitable, Instant horaRetraso){
        super(invitable);
        this.horaRetraso = horaRetraso;
    }

    /**
     * Devuelve el instante de retraso.
     *
     * @return hora de llegada tardia
     */
    public Instant getHoraRetraso(){
        return horaRetraso;
    }

    /**
     * Cambia el instante del retraso.
     *
     * @param horaRetraso nueva hora de retraso
     */
    public void setHora(Instant horaRetraso){
        this.horaRetraso = horaRetraso;
    }

    /**
     * Devuelve una representacion de texto del retraso.
     *
     * @return texto con el retraso y la hora
     */
    @Override
    public String toString() {
        return super.toString() + " | Hora de llegada: " + horaRetraso;
    }
}
