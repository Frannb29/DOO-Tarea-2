package modelo;
import java.time.Instant;
import java.util.Objects;

/**
 * Clase que representa un participante externo invitado a una reunion.
 */
public class Externos implements Invitable{
    private String nombre;
    private String correo;

    /**
     * Crea un invitado externo con nombre y correo.
     *
     * @param nombre nombre del invitado externo
     * @param correo correo electronico del invitado externo
     */
    public Externos(String nombre,String correo){
        this.nombre=Objects.requireNonNull(nombre);
        this.correo=Objects.requireNonNull(correo);
    }

    /**
     * Devuelve el nombre del invitado externo.
     *
     * @return nombre del invitado
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Cambia el nombre del invitado externo.
     *
     * @param nuevoNombre nuevo nombre
     */
    public void setNombre(String nuevoNombre){
        this.nombre=Objects.requireNonNull(nuevoNombre);
    }

    /**
     * Devuelve el correo del invitado externo.
     *
     * @return correo electronico
     */
    public String getCorreo(){
        return correo;
    }

    /**
     * Cambia el correo del invitado externo.
     *
     * @param nuevoCorreo nuevo correo electronico
     */
    public void setCorreo(String nuevoCorreo){
        this.correo=Objects.requireNonNull(nuevoCorreo);
    }

    /**
     * Devuelve una representacion de texto del invitado externo.
     *
     * @return descripcion del invitado externo
     */
    @Override
    public String toString() {
        return "Nombre: "+nombre + ", Correo: " + correo;
    }

    /**
     * Genera una invitacion para este invitado externo.
     *
     * @param hora instante de la invitacion
     * @return la invitacion creada
     */
    @Override
    public Invitacion invitar(Instant hora){
        System.out.println("Invitacion a Externo enviada");
        return new Invitacion(hora,this);
    }
}
