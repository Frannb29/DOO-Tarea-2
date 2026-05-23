package modelo;

/**
 * Clase que representa una asistencia de un participante a una reunion.
 */
public class Asistencia {
    private Invitable asistente;

    /**
     * Crea una asistencia para un participante invitado.
     *
     * @param asistente participante que asiste a la reunion
     */
    public Asistencia (Invitable asistente){
        this.asistente = asistente;
    }

    /**
     * Devuelve el participante asociado a esta asistencia.
     *
     * @return el asistente registrado
     */
    public Invitable getAsistente(){
        return asistente;
    }

    /**
     * Cambia el participante asociado a esta asistencia.
     *
     * @param asistente nuevo participante
     */
    public void setAsistente(Invitable asistente){
        this.asistente = asistente;
    }

    /**
     * Devuelve una representacion de texto de la asistencia.
     *
     * @return texto con el asistente
     */
    @Override
    public String toString() {
        return "Asistente: " + asistente.toString();
    }
}
