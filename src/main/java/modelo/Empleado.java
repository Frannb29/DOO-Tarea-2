package modelo;
import java.time.Instant;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    public Empleado(String id,String apellidos,String nombre,String correo){
        this.id=id;
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.correo=correo;
    }
    public String getId(){
        return id;
    }
    public void setId(String nuevaId){
        id=nuevaId;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String nuevoApellidos){
        apellidos=nuevoApellidos;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nuevoNombre){
        nombre=nuevoNombre;
    }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String nuevoCorreo){
        correo=nuevoCorreo;
    }
    @Override
    public String toString(){
        return nombre+" "+apellidos+" ID:"+id+" "+correo;
    }
    @Override
    public Invitacion invitar(Instant hora){
        System.out.println("Invitación a Empleado enviada");
        return new Invitacion(hora,this);
    }
}