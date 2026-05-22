package modelo;
import java.time.Instant;

public class Externos implements Invitable{
    private String nombre;
    private String correo;
    public Externos(String nombre,String correo){
        this.nombre=nombre;
        this.correo=correo;
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
    public String toString() {
        return nombre + " " + correo;
    }
    @Override
    public Invitacion invitar(Instant hora){
        System.out.println("Invitación a Externo enviada");
        return new Invitacion(hora,this);
    }
}
