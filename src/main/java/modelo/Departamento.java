package modelo;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Clase que representa un departamento como invitado a una reunion.
 */
public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;
    /**
     * Crea un departamento con un nombre.
     *
     * @param nombre nombre del departamento
     */
    public Departamento(String nombre){
        listaEmpleados=new ArrayList<Empleado>();
        this.nombre=nombre;
    }
    /**
     * Agrega un empleado al departamento.
     *
     * @param x empleado que se agrega
     */
    public void agregarEmpleado(Empleado x){
        listaEmpleados.add(x);
    }
    /**
     * Devuelve la cantidad de empleados en el departamento.
     *
     * @return numero de empleados
     */
    public int obtenerCantidadEmpleados(){
        return listaEmpleados.size();
    }
    /**
     * Devuelve el nombre del departamento.
     *
     * @return nombre del departamento
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Cambia el nombre del departamento.
     *
     * @param nuevoNombre nuevo nombre del departamento
     */
    public void setNombre(String nuevoNombre){
        nombre=nuevoNombre;
    }
    /**
     * Devuelve la lista de todos los empleados.
     *
     * @return lista de empleados
     */
    public ArrayList<Empleado> getEmpleados(){
        return listaEmpleados;
    }
    /**
     * Devuelve una representacion de texto del departamento y sus empleados.
     *
     * @return texto con el departamento y empleados
     */
    @Override
    public String toString() {
        String texto=nombre+":";
        for(int i=0;i<listaEmpleados.size();i++){
            Empleado empleado=listaEmpleados.get(i);
            texto+=" "+empleado;
        }
        return texto;
    }
    /**
     * Genera una invitacion para este departamento.
     *
     * @param hora instante de la invitacion
     * @return la invitacion creada
     */
    @Override
    public Invitacion invitar(Instant hora){
        System.out.println("Invitacion a Departamento enviada");
        return new Invitacion(hora,this);
    }
}