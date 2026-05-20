package modelo;
import java.time.Instant;

public class Invitacion {
    private Instant hora;
    public Invitacion(Instant hora){
        this.hora=hora;
    }
    public Instant getHora(){
        return hora;
    }
    public void setHora(Instant nuevaHora){
        hora=nuevaHora;
    }
}
