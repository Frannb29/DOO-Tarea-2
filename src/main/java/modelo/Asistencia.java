package modelo;

public class Asistencia {
    private Invitable asistente;
    public Asistencia (Invitable asistente){
        this.asistente = asistente;
    }
    public Invitable getAsistente(){
        return asistente;
    }
    public void setAsistente(Invitable asistente){
        this.asistente = asistente;
    }
    @Override
    public String toString() {
        return "Asistente: " + asistente.toString();
    }
}
