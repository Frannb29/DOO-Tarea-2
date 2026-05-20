package modelo;
import java.time.*;

public class ReunionVirtual extends Reunion{
    private String enlace;

    ReunionVirtual(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, 
        tipoReunion tipo, String enlace){
            super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
            this.enlace=enlace;
        }
}