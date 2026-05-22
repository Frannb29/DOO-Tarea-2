package modelo;
import java.time.Instant;

public class Invitacion{
    private Instant hora;
    private Invitable invitado;
    public Invitacion(Instant hora,Invitable invitado){
        this.hora=hora;
        this.invitado=invitado;
    }
    public Instant getHora(){
        return hora;
    }
    public void setHora(Instant nuevaHora){
        hora=nuevaHora;
    }
    public Invitable getInvitado(){
        return invitado;
    }
    public void setInvitado(Invitable nuevoInvitado){
        invitado=nuevoInvitado;
    }
    @Override
    public String toString(){
        return "hora: "+hora+" invitado: "+invitado;
    }
}