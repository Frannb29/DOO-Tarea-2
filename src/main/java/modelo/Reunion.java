package modelo;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase abstracta que representa una reunion con invitaciones, notas y asistencias.
 */
public abstract class Reunion {
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;

    private Instant horaFin;
    private Empleado organizador;
    private tipoReunion tipo;
    private List<Nota> notas;
    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;

    /**
     * Crea una reunion con fecha, hora prevista, duracion prevista, organizador y tipo.
     *
     * @param fecha fecha de la reunion
     * @param horaPrevista hora prevista de inicio
     * @param duracionPrevista duracion prevista
     * @param organizador organizador de la reunion
     * @param tipo tipo de reunion
     */
    public Reunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipo){
        this.fecha=Objects.requireNonNull(fecha);
        this.horaPrevista=Objects.requireNonNull(horaPrevista);
        this.duracionPrevista=Objects.requireNonNull(duracionPrevista);
        this.organizador=Objects.requireNonNull(organizador);
        this.tipo=Objects.requireNonNull(tipo);

        this.horaInicio=null;
        this.horaFin=null;
        this.notas=new ArrayList<>();
        this.asistencias=new ArrayList<>();
        this.invitaciones=new ArrayList<>();

    }

    /**
     * Agrega una nota a la reunion.
     *
     * @param nota nota que se agrega
     */
    public void agregarNota(Nota nota){
        Objects.requireNonNull(nota);
        notas.add(nota);
    }

    /**
     * Devuelve la lista de notas de la reunion.
     *
     * @return lista de notas
     */
    public List<Nota> obtenerNotas(){
        return notas;
    }

    /**
     * Invita a un participante a la reunion.
     *
     * @param invitado participante a invitar
     * @param hora instante previsto para la participacion
     */
    public void invitar(Invitable invitado, Instant hora){
        Objects.requireNonNull(invitado);
        Objects.requireNonNull(hora);
        
        if (invitado instanceof Departamento dep){
            for(Empleado emp : dep.getEmpleados()){
                invitar(emp, hora);
            }
            return;
        }
        Invitacion invitacion = invitado.invitar(hora);
        for(Invitacion inv : invitaciones){
            if(inv.getInvitado()==invitacion){
                System.out.println("Invitacion ya registrada.");
                return;
            }
        }
        if (horaFin==null){
            invitaciones.add(invitacion);
        }
        else{
            System.out.println("La reunion ya termino.");
        }
    }

    /**
     * Registra la asistencia de un invitado.
     *
     * @param asistente participante que asiste
     */
    public void agregarAsistencia(Invitable asistente){
        Objects.requireNonNull(asistente);

        boolean estaInvitado=false;
        for (Invitacion inv : invitaciones){
            if (inv.getInvitado()==asistente){
                estaInvitado=true;
                break;
            }
        }
        if (!estaInvitado){
            System.out.println("No puede asistir, no esta invitado.");
            return;
        }

        for (Asistencia a : asistencias){
            if (a.getAsistente()==asistente){
                System.out.println("Asistencia ya registrada.");
                return;
            }
        }

        if(horaFin!=null){
            System.out.println("La reunion ya termino.");
        }
        else if (horaInicio != null){
            asistencias.add(new Retraso(asistente, Instant.now()));
        } else {
            asistencias.add(new Asistencia(asistente));
        }
    }
    

    /**
     * Devuelve la lista de asistencias registradas.
     *
     * @return lista de asistencias
     */
    public List<Asistencia> obtenerAsistencias(){
        return asistencias;
    }

    /**
     * Devuelve la lista de invitados que no asistieron.
     *
     * @return lista de ausencias
     */
    public List<Invitable> obtenerAusencias(){
        List<Invitable> ausencias=new ArrayList<>();
        for (Invitacion invitacion : invitaciones){
            Invitable invitado = invitacion.getInvitado();
            boolean asistio = false;
            for(Asistencia asistencia : asistencias){
                if(asistencia.getAsistente()==invitado){
                    asistio = true;
                    break;
                }
            }
            if(asistio == false){
                ausencias.add(invitado);
            }
        }
        return ausencias;
    }

    /**
     * Devuelve la lista de asistencias con retraso.
     *
     * @return lista de retrasos
     */
    public List<Retraso> obtenerRetrasos(){
        List<Retraso> retrasos = new ArrayList<>();

        for (Asistencia asistencia : asistencias){
            if (asistencia instanceof Retraso){
                retrasos.add((Retraso) asistencia);
            }
        }
        return retrasos;
    }

    /**
     * Devuelve el total de asistencias registradas.
     *
     * @return numero total de asistencias
     */
    public int obtenerTotalAsistencia(){
        return this.asistencias.size();
    }

    /**
     * Calcula el porcentaje de invitados que asistieron.
     *
     * @return porcentaje de asistencias
     */
    public float obtenerPorcentajeAsistencias(){
        if (invitaciones.isEmpty()) return 0.0f;
        return ((float)obtenerTotalAsistencia()/invitaciones.size())*100;
    }

    /**
     * Calcula la duracion real de la reunion entre inicio y fin.
     *
     * @return duracion real en minutos
     */
    public float calcularTiempoReal(){
        if (horaInicio!=null && horaFin!=null){
            Duration tiempoReal=Duration.between(horaInicio, horaFin);
            return (float) tiempoReal.toMinutes();
        }
        return 0.0f;
    }

    /**
     * Registra el inicio de la reunion en el instante actual.
     */
    public void iniciar(){
        this.horaInicio=Instant.now();
    }

    /**
     * Registra el fin de la reunion en el instante actual.
     */
    public void finalizar(){
        this.horaFin=Instant.now();
    }
    /**
     * Devuelve la fecha de la reunion.
     *
     * @return fecha programada
     */
    public LocalDate getFecha(){
        return fecha;
    }
    public Instant getHoraInicio(){
        return horaInicio;
    }
    public Instant getHoraFin(){
        return horaFin;
    }
    /**
     * Devuelve la duracion total calculada de la reunion.
     *
     * @return duracion total en minutos
     */
    public float getDuracionTotal(){
        return calcularTiempoReal();
    }
    public tipoReunion getTipoReunion(){
        return tipo;
    }
    public Empleado getOrganizador(){
        return organizador;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    public List<Invitacion> getInvitaciones(){
        return invitaciones;
    }

    /**
     * Cambia la fecha de la reunion.
     *
     * @param fecha nueva fecha
     */
    public void setFecha(LocalDate fecha){
        this.fecha=Objects.requireNonNull(fecha);
    }
    /**
     * Cambia la hora prevista de inicio.
     *
     * @param horaPrevista nueva hora prevista
     */
    public void setHoraPrevista(Instant horaPrevista){
        this.horaPrevista=Objects.requireNonNull(horaPrevista);
    }
    /**
     * Cambia la duracion prevista de la reunion.
     *
     * @param duracionPrevista nueva duracion prevista
     */
    public void setDuracionPrevista(Duration duracionPrevista){
        this.duracionPrevista=Objects.requireNonNull(duracionPrevista);
    }
    /**
     * Cambia el organizador de la reunion.
     *
     * @param organizador nuevo organizador
     */
    public void setOrganizador(Empleado organizador){
        this.organizador=Objects.requireNonNull(organizador);
    }
    /**
     * Cambia el tipo de reunion.
     *
     * @param tipo nuevo tipo de reunion
     */
    public void setTipo(tipoReunion tipo){
        this.tipo=Objects.requireNonNull(tipo);
    }

    /**
     * Genera un informe de la reunion.
     *
     * @param nombreArchivo nombre del archivo que contiene el informe
     */
    public void generarInforme(String nombreArchivo){
        Informe informe = new Informe();
        informe.generarInforme(this, nombreArchivo);
    }


    public void generarInforme(String nombreArchivo){
        Informe informe = new Informe();
        informe.generarInforme(this, nombreArchivo);
    }

    @Override
    public String toString(){
        String str="Tipo: "+tipo+"\nFecha: "+fecha+"\nDatos del organizador:\n"+organizador+"\nTotal invitados: "+invitaciones.size()+
        "\nTotal asistencias: "+asistencias.size()+"\n--------\nNotas:\n";
        for (Nota nota : notas){
            str+=nota+"\n";
        }
        return str;
    }
}