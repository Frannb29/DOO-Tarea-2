package modelo;
import java.time.Instant;
import java.util.Objects;

/**
 * Clase que representa un empleado que puede ser invitado a una reunion.
 */
public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    /**
     * Crea un empleado con sus datos basicos.
     *
     * @param id identificador del empleado
     * @param apellidos apellidos del empleado
     * @param nombre nombre del empleado
     * @param correo correo electronico del empleado
     */
    public Empleado(String id,String apellidos,String nombre,String correo){
        this.id=Objects.requireNonNull(id);
        this.apellidos=Objects.requireNonNull(apellidos);
        this.nombre=Objects.requireNonNull(nombre);
        this.correo=Objects.requireNonNull(correo);
    }
    /**
     * Devuelve el identificador del empleado.
     *
     * @return id del empleado
     */
    public String getId(){
        return id;
    }
    /**
     * Cambia el identificador del empleado.
     *
     * @param nuevaId nuevo identificador
     */
    public void setId(String nuevaId){
        this.id=Objects.requireNonNull(nuevaId);
    }
    /**
     * Devuelve los apellidos del empleado.
     *
     * @return apellidos del empleado
     */
    public String getApellidos(){
        return apellidos;
    }
    /**
     * Cambia los apellidos del empleado.
     *
     * @param nuevoApellidos nuevos apellidos
     */
    public void setApellidos(String nuevoApellidos){
        this.apellidos=Objects.requireNonNull(nuevoApellidos);
    }
    /**
     * Devuelve el nombre del empleado.
     *
     * @return nombre del empleado
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Cambia el nombre del empleado.
     *
     * @param nuevoNombre nuevo nombre
     */
    public void setNombre(String nuevoNombre){
        this.nombre=Objects.requireNonNull(nuevoNombre);
    }
    /**
     * Devuelve el correo electronico del empleado.
     *
     * @return correo electronico
     */
    public String getCorreo(){
        return correo;
    }
    /**
     * Cambia el correo electronico del empleado.
     *
     * @param nuevoCorreo nuevo correo electronico
     */
    public void setCorreo(String nuevoCorreo){
        this.correo=Objects.requireNonNull(nuevoCorreo);
    }
    /**
     * Devuelve una representacion de texto del empleado.
     *
     * @return descripcion del empleado
     */
    @Override
    public String toString(){
        return "Nombre: "+nombre+", Apellidos: "+apellidos+", ID:"+id+", Correo: "+correo;
    }
    /**
     * Genera una invitacion para este empleado.
     *
     * @param hora instante de la invitacion
     * @return la invitacion creada
     */
    @Override
    public Invitacion invitar(Instant hora){
        System.out.println("Invitacion a Empleado enviada");
        return new Invitacion(hora,this);
    }
}