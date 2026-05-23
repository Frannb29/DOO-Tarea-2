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

            if(reunion instanceof ReunionVirtual){
                ReunionVirtual virtual = (ReunionVirtual) reunion;
                writer.println("Enlace: " + virtual.getEnlace());
            }

            if(reunion instanceof ReunionPresencial){
                ReunionPresencial presencial = (ReunionPresencial) reunion;
                writer.println("Sala: " + presencial.getSala());
            }

            writer.println("Lista de Participantes:");
            for (Asistencia asistente : reunion.obtenerAsistencias()) {
                writer.println("- " + asistente.toString());
            }
            writer.println("Retrasos:");
            for (Retraso r : reunion.obtenerRetrasos()) {
                writer.println("- " + r.toString());
            }
            writer.println("Notas:");
            for (Nota n : reunion.obtenerNotas()) {
                writer.println("- " + n.getContenido());
            }
            writer.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
