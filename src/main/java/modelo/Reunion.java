package modelo;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Reunion {
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin; 
    private Empleado organizador;
    private tipoReunion tipo;
    private Nota nota;
    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;

    public Reunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipo){
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevista=duracionPrevista;
        this.organizador=organizador;
        this.tipo=tipo;
         
        this.asistencias=new ArrayList<>();
        this.invitaciones=new ArrayList<>();

    }

    public List<Asistencia> obtenerAsistencias(){
        return this.asistencias;
    }

    public List<Asistencia> obtenerAusencias(){
        List<Asistencia> ausencias=new ArrayList<>();
        return ausencias;   
    }

    public List<Retraso> obtenerRetrasos(){

    }

    public int obtenerTotalAsistencia(){
        return this.asistencias.size();
    }

    public float obtenerPorcentajeAsistencias(){
        if (invitaciones.isEmpty()) return 0.0f;
        return (float) (obtenerTotalAsistencia()/invitaciones.size())*100;
    }

    public float calcularTiempoReal(){
        if (horaInicio!=null && horaFin!=null){
            Duration tiempoReal=Duration.between(horaInicio, horaFin);
            return (float) tiempoReal.toMinutes();
        }
        return 0.0f;
    }

    public void iniciar(){
        this.horaInicio=Instant.now();
    }

    public void finalizar(){
        this.horaFin=Instant.now();
    }

}
