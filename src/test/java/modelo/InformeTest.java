package modelo;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.time.LocalDate;

class InformeTest {

    @Test
    void testGeneracionArchivo() {
        Empleado emp = new Empleado("1","Fuentes","Pepe","pepe@udec.cl");
        ReunionVirtual reunionPrueba = new ReunionVirtual(LocalDate.now(), Instant.now(), Duration.ofMinutes(60), emp, tipoReunion.TECNICA, "https.skdjojfjsofj");

        reunionPrueba.agregarNota(new Nota("Hola que tal"));

        reunionPrueba.agregarAsistencia(emp);

        // 2. Ejecutamos tu generador de informe
        Informe generador = new Informe();
        String rutaArchivo = "informe_prueba.txt";
        generador.generarInforme(reunionPrueba, rutaArchivo);

        // 3. Verificamos mediante JUnit que el archivo realmente se creó en el computador
        File archivoCreado = new File(rutaArchivo);
        assertTrue(archivoCreado.exists(), "El archivo .txt debió haberse creado en la raíz.");

    }
}