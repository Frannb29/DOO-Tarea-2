package modelo;

public class Externos implements Invitable{
    private String nombre;
    private String correo;
    public Externos(String nombre,String correo){
        this.nombre=nombre;
        this.correo=correo;
    }
    public void invitar(){
        System.out.println("Invitacion a Externo enviada");
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
}
