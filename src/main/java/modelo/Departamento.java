package modelo;
import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;
    public Departamento(String nombre){
        listaEmpleados=new ArrayList<Empleado>();
        this.nombre=nombre;
    }
    public void agregarEmpleado(Empleado x){
        listaEmpleados.add(x);
    }
    public int obtenerCantidadEmpleados(){
        return listaEmpleados.size();
    }
    public void invitar(){
        System.out.println("Invitación a Departamento enviada");
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nuevoNombre){
        nombre=nuevoNombre;
    }
    @Override
    public String toString() {
        String texto=nombre+":";
        for(int i=0;i<listaEmpleados.size();i++){
            Empleado empleado=listaEmpleados.get(i);
            texto+=" "+empleado;
        }
        return texto;
    }
}
