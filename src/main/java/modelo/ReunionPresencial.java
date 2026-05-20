package modelo;
import java.time.*;

public class ReunionPresencial extends Reunion{
    private String sala;

    ReunionPresencial(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, 
        tipoReunion tipo, String sala){
            super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
            this.sala=sala;
        }
        
}
