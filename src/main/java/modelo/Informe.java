package modelo;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;

public class Informe {
    public void generarInforme(Reunion reunion, String nombreArchivo){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo));

            writer.println("Informe de Reunion");
            writer.println("Fecha: " + reunion.getFecha());
            writer.println("Hora Inicio: " + reunion.getHoraInicio());
            writer.println("Hora Fin: " + reunion.getHoraFin());
            writer.println("Duracion Total: " + reunion.getDuracionTotal());
            writer.println("Tipo de Reunion: " + reunion.getTipoReunion());
            writer.println("Enlace o sala de Reunion:");
            writer.println("Lista de Participantes:");
            for (Asistencia asistente : reunion.obtenerAsistencias()) {
                writer.println("- " + asistente.toString()); // Llama al toString de Asistencia/Retraso
            }
            writer.println("Retrasos:");
            for (Retraso r : reunion.obtenerRetrasos()) {
                writer.println("- " + r.toString());
            }
            writer.println("Notas:");
            for (Nota n : reunion.obtenerNotas()) {
                writer.println("- " + n.getContenido()); // Utiliza tu clase Nota
            }
            writer.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
