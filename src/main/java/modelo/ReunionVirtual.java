package modelo;
import java.time.*;

/**
 * Clase que representa una reunion virtual con enlace.
 */
public class ReunionVirtual extends Reunion{
    private String enlace;

    /**
     * Crea una reunion virtual con datos basicos y el enlace.
     *
     * @param fecha fecha de la reunion
     * @param horaPrevista hora prevista de inicio
     * @param duracionPrevista duracion prevista de la reunion
     * @param organizador empleado organizador
     * @param tipo tipo de reunion
     * @param enlace enlace de la reunion virtual
     */
    ReunionVirtual(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, 
        tipoReunion tipo, String enlace){
            super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
            this.enlace=enlace;
    }
    /**
     * Devuelve el enlace de la reunion virtual.
     *
     * @return enlace de la reunion
     */
    public String getEnlace(){
        return enlace;
    }
    /**
     * Cambia el enlace de la reunion virtual.
     *
     * @param enlace nuevo enlace
     */
    public void setEnlace(String enlace){
        this.enlace=enlace;
    }
}