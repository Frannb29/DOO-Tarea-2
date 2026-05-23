package modelo;
import java.time.Instant;

/**
 * Interfaz para los objetos que se pueden invitar a una reunion.
 */
public interface Invitable {
    /**
     * Crea una invitacion para el objeto.
     *
     * @param hora instante de la invitacion
     * @return la invitacion generada
     */
    public Invitacion invitar(Instant hora);
}