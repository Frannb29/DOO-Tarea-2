package modelo;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.time.LocalDate;

class InformeTest {

    /**
     * Verifica que el archivo del informe se genere correctamente
     */
    @Test
    void testGeneracionArchivo() {
        Empleado emp = new Empleado("1","Carrasco","Luis","lcarrasco@udec.cl");
        ReunionVirtual reunionPrueba = new ReunionVirtual(LocalDate.now(), Instant.now(), Duration.ofMinutes(60), emp, tipoReunion.TECNICA, "https.skdjojfjsofj");

        reunionPrueba.agregarNota(new Nota("Reunion iniciada"));

        reunionPrueba.agregarAsistencia(emp);

        reunionPrueba.iniciar();
        reunionPrueba.finalizar();

        // Generacion del archivo de informe con los datos de reunionPrueba

        Informe generador = new Informe();
        String rutaArchivo = "informe_prueba.txt";
        generador.generarInforme(reunionPrueba, rutaArchivo);


        File archivoCreado = new File(rutaArchivo);

        // Si el archivo existe retorna True, de lo contrario retorna False
        assertTrue(archivoCreado.exists(), "El archivo .txt no se generó correctamente");

    }
}