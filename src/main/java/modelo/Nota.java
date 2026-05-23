package modelo;
import java.util.Objects;
/**
 * Clase que representa una nota o comentario sobre una reunion.
 */
public class Nota {
    private String contenido;

    /**
     * Crea una nota con contenido de texto.
     *
     * @param contenido texto de la nota
     */
    public Nota(String contenido){
        this.contenido=Objects.requireNonNull(contenido);
    }

    /**
     * Devuelve el contenido de la nota.
     *
     * @return texto de la nota
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Cambia el contenido de la nota.
     *
     * @param contenido nuevo texto de la nota
     */
    public void setContenido(String contenido) {
        this.contenido = Objects.requireNonNull(contenido);
    }

    /**
     * Devuelve una representacion de texto de la nota.
     *
     * @return contenido de la nota
     */
    @Override
    public String toString(){
        return contenido;
    }
}
