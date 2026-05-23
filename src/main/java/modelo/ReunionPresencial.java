package modelo;
import java.time.*;

/**
 * Clase que representa una reunion presencial con sala asignada.
 */
public class ReunionPresencial extends Reunion{
    private String sala;

    /**
     * Crea una reunion presencial con datos basicos y sala.
     *
     * @param fecha fecha de la reunion
     * @param horaPrevista hora prevista de inicio
     * @param duracionPrevista duracion prevista de la reunion
     * @param organizador empleado organizador
     * @param tipo tipo de reunion
     * @param sala sala de la reunion
     */
    ReunionPresencial(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, 
        tipoReunion tipo, String sala){
            super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
            this.sala=sala;
    }

    /**
     * Devuelve la sala de la reunion presencial.
     *
     * @return sala asignada
     */
    public String getSala(){
        return sala;
    }

    /**
     * Cambia la sala de la reunion presencial.
     *
     * @param sala nueva sala
     */
    public void setSala(String sala){
        this.sala=sala;
    }
        
}
