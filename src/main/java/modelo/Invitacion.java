package modelo;
import java.time.Instant;

/**
 * Clase que representa una invitacion de un participante a una reunion.
 */
public class Invitacion{
    private Instant hora;
    private Invitable invitado;
    /**
     * Crea una invitacion con hora e invitado.
     *
     * @param hora instante de la invitacion
     * @param invitado participante invitado
     */
    public Invitacion(Instant hora,Invitable invitado){
        this.hora=hora;
        this.invitado=invitado;
    }
    /**
     * Devuelve la hora de la invitacion.
     *
     * @return instante de la invitacion
     */
    public Instant getHora(){
        return hora;
    }
    /**
     * Cambia la hora de la invitacion.
     *
     * @param nuevaHora nueva hora de la invitacion
     */
    public void setHora(Instant nuevaHora){
        this.hora=nuevaHora;
    }
    /**
     * Devuelve el invitado de la invitacion.
     *
     * @return participante invitado
     */
    public Invitable getInvitado(){
        return invitado;
    }
    /**
     * Cambia el invitado de la invitacion.
     *
     * @param nuevoInvitado nuevo participante invitado
     */
    public void setInvitado(Invitable nuevoInvitado){
        this.invitado=nuevoInvitado;
    }
    /**
     * Devuelve una representacion de texto de la invitacion.
     *
     * @return texto con hora e invitado
     */
    @Override
    public String toString(){
        return "hora: "+hora+" invitado: "+invitado;
    }
}