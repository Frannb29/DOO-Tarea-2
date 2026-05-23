package modelo;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGeneral {

    private static final LocalDate FECHA = LocalDate.of(2026, 5, 23);
    private static final Instant HORA_PREVISTA = Instant.parse("2026-05-23T10:00:00Z");
    private static final Duration DURACION_PREVISTA = Duration.ofMinutes(90);
    private static final Empleado ORGANIZADOR = new Empleado("1", "Perez", "Sofia", "sperez@gmail.com");

    private static class TestReunion extends Reunion {
        public TestReunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipo) {
            super(fecha, horaPrevista, duracionPrevista, organizador, tipo);
        }
    }

    private Reunion crearReunion() {
        return new TestReunion(FECHA, HORA_PREVISTA, DURACION_PREVISTA, ORGANIZADOR, tipoReunion.TECNICA);
    }

    @Test
    void testConstructorRechazaNulls() {
        assertThrows(NullPointerException.class, () -> new TestReunion(null, HORA_PREVISTA, DURACION_PREVISTA, ORGANIZADOR, tipoReunion.TECNICA));
        assertThrows(NullPointerException.class, () -> new TestReunion(FECHA, null, DURACION_PREVISTA, ORGANIZADOR, tipoReunion.TECNICA));
        assertThrows(NullPointerException.class, () -> new TestReunion(FECHA, HORA_PREVISTA, null, ORGANIZADOR, tipoReunion.TECNICA));
        assertThrows(NullPointerException.class, () -> new TestReunion(FECHA, HORA_PREVISTA, DURACION_PREVISTA, null, tipoReunion.TECNICA));
        assertThrows(NullPointerException.class, () -> new TestReunion(FECHA, HORA_PREVISTA, DURACION_PREVISTA, ORGANIZADOR, null));
    }

    @Test
    void testEmpleadoRechazaNulls() {
        assertThrows(NullPointerException.class, () -> new Empleado(null, "Perez", "Sofia", "sperez@gmail.com"));
        assertThrows(NullPointerException.class, () -> new Empleado("1", null, "Sofia", "sperez@gmail.com"));
        assertThrows(NullPointerException.class, () -> new Empleado("1", "Perez", null, "sperez@gmail.com"));
        assertThrows(NullPointerException.class, () -> new Empleado("1", "Perez", "Sofia", null));
    }

    @Test
    void testDepartamentoRechazaNullNombre() {
        assertThrows(NullPointerException.class, () -> new Departamento(null));
    }

    @Test
    void testExternosRechazaNulls() {
        assertThrows(NullPointerException.class, () -> new Externos(null, "diego@externo.com"));
        assertThrows(NullPointerException.class, () -> new Externos("Diego", null));
    }

    @Test
    void testAgregarNota() {
        Reunion reunion = crearReunion();
        Nota nota = new Nota("Punto 1");

        reunion.agregarNota(nota);

        List<Nota> notas = reunion.obtenerNotas();
        assertEquals(1, notas.size());
        assertSame(nota, notas.get(0));
        assertEquals("Punto 1", notas.get(0).getContenido());
    }

    @Test
    void testAgregarAsistencia() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "Gomez", "Hugo", "hugomez@outlook.com");
        reunion.invitar(invitado, Instant.parse("2025-09-10T10:00:00Z"));

        reunion.agregarAsistencia(invitado);

        List<Asistencia> asistencias = reunion.obtenerAsistencias();
        assertEquals(1, asistencias.size());
        assertSame(invitado, asistencias.get(0).getAsistente());
    }

    @Test
    void testAgregarAsistenciaSinInvitacion() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "Sanza", "Pancho", "psanz@gmail.com");

        reunion.agregarAsistencia(invitado);

        assertTrue(reunion.obtenerAsistencias().isEmpty());
    }

    @Test
    void testCalcularTiempoRealCero() {
        Reunion reunion = crearReunion();
        assertEquals(0.0f, reunion.calcularTiempoReal());
    }

    @Test
    void testIniciarAndFinalizar() {
        Reunion reunion = crearReunion();

        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio());

        reunion.finalizar();
        assertNotNull(reunion.getHoraFin());

        assertTrue(reunion.getDuracionTotal() >= 0.0f);
    }

    @Test
    void testGetFecha() {
        Reunion reunion = crearReunion();
        assertEquals(FECHA, reunion.getFecha());
    }

    @Test
    void testGetHoraPrevista() {
        Reunion reunion = crearReunion();
        assertEquals(HORA_PREVISTA, reunion.getHoraPrevista());
    }

    @Test
    void testGetDuracionPrevista() {
        Reunion reunion = crearReunion();
        assertEquals(DURACION_PREVISTA, reunion.getDuracionPrevista());
    }

    @Test
    void testGetOrganizador() {
        Reunion reunion = crearReunion();
        assertSame(ORGANIZADOR, reunion.getOrganizador());
    }

    @Test
    void testGetTipoReunion() {
        Reunion reunion = crearReunion();
        assertEquals(tipoReunion.TECNICA, reunion.getTipoReunion());
    }

    @Test
    void testGetInvitaciones() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "Welling", "Tom", "tom@gmail.com");
        reunion.invitar(invitado, Instant.parse("2001-09-11T08:00:00Z"));

        assertEquals(1, reunion.getInvitaciones().size());
        assertSame(invitado, reunion.getInvitaciones().get(0).getInvitado());
    }

    @Test
    void testInvitarExterno() {
        Reunion reunion = crearReunion();
        Externos externo = new Externos("Diego", "diego@hotmail.com");

        reunion.invitar(externo, Instant.parse("2026-05-22T14:00:00Z"));

        assertEquals(1, reunion.getInvitaciones().size());
        assertSame(externo, reunion.getInvitaciones().get(0).getInvitado());
    }

    @Test
    void testInvitarDespuesDeFinalizarNoAgregaInvitacion() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "Sanchez", "Sofia", "ssanchez@gmail.com");

        reunion.finalizar();
        reunion.invitar(invitado, Instant.parse("2026-05-23T17:00:00Z"));

        assertEquals(0, reunion.getInvitaciones().size());
    }

    @Test
    void testAgregarAsistenciaDespuesDeFinalizarNoRegistra() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "Huguez", "Hugo", "hugo@gmail.com");

        reunion.invitar(invitado, Instant.parse("2024-01-01T11:00:00Z"));
        reunion.finalizar();
        reunion.agregarAsistencia(invitado);

        assertEquals(0, reunion.obtenerAsistencias().size());
    }

    @Test
    void testObtenerAsistencias() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "Lopez", "Luis", "luis@gmail.com");
        reunion.invitar(invitado, Instant.parse("2008-07-13T13:00:00Z"));
        reunion.agregarAsistencia(invitado);

        assertEquals(1, reunion.obtenerAsistencias().size());
    }

    @Test
    void testObtenerAusencias() {
        Reunion reunion = crearReunion();
        Empleado asistente1 = new Empleado("2", "Riquelme", "Rob", "robtop@gmail.com");
        Empleado asistente2 = new Empleado("3", "Diaz", "Marta", "mdiaz@gmail.com");

        reunion.invitar(asistente1, Instant.parse("2026-05-23T10:00:00Z"));
        reunion.invitar(asistente2, Instant.parse("2026-05-23T10:00:00Z"));
        reunion.agregarAsistencia(asistente1);

        List<Invitable> ausencias = reunion.obtenerAusencias();
        assertEquals(1, ausencias.size());
        assertSame(asistente2, ausencias.get(0));
    }

    @Test
    void testObtenerRetrasos() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "", "L", "l@gmail.com");
        reunion.invitar(invitado, Instant.parse("2019-05-28T18:00:00Z"));

        reunion.iniciar();
        reunion.agregarAsistencia(invitado);

        List<Retraso> retrasos = reunion.obtenerRetrasos();
        assertFalse(retrasos.isEmpty());
        assertSame(invitado, retrasos.get(0).getAsistente());
    }

    @Test
    void testObtenerTotalAsistencia() {
        Reunion reunion = crearReunion();
        Empleado invitado = new Empleado("2", "Paul", "Logan", "lpaul@gmail.com");
        reunion.invitar(invitado, Instant.parse("2016-05-10T10:00:00Z"));
        reunion.agregarAsistencia(invitado);

        assertEquals(1, reunion.obtenerTotalAsistencia());
    }

    @Test
    void testObtenerPorcentajeAsistencias() {
        Reunion reunion = crearReunion();
        Empleado asistente1 = new Empleado("2", "Brown", "Mr", "srbrwn@google.com");
        Empleado asistente2 = new Empleado("3", "Vera", "Angela", "avera@ejemplo.com");

        reunion.invitar(asistente1, Instant.parse("2026-05-23T17:00:00Z"));
        reunion.invitar(asistente2, Instant.parse("2026-05-23T17:00:00Z"));
        reunion.agregarAsistencia(asistente1);

        assertEquals(50.0f, reunion.obtenerPorcentajeAsistencias());
    }

    @Test
    void testSetFechaRechazaNull() {
        Reunion reunion = crearReunion();
        assertThrows(NullPointerException.class, () -> reunion.setFecha(null));
    }

    @Test
    void testSetHoraPrevistaRechazaNull() {
        Reunion reunion = crearReunion();
        assertThrows(NullPointerException.class, () -> reunion.setHoraPrevista(null));
    }

    @Test
    void testSetDuracionPrevistaRechazaNull() {
        Reunion reunion = crearReunion();
        assertThrows(NullPointerException.class, () -> reunion.setDuracionPrevista(null));
    }

    @Test
    void testSetOrganizadorRechazaNull() {
        Reunion reunion = crearReunion();
        assertThrows(NullPointerException.class, () -> reunion.setOrganizador(null));
    }

    @Test
    void testSetTipoRechazaNull() {
        Reunion reunion = crearReunion();
        assertThrows(NullPointerException.class, () -> reunion.setTipo(null));
    }

    @Test
    void testInvitarDepartamento() {
        Reunion reunion = crearReunion();
        Departamento dept = new Departamento("Ventas");
        Empleado e1 = new Empleado("2", "Morgan", "Ann", "amorgan@gmail.com");
        Empleado e2 = new Empleado("3", "Chigurh", "Anton", "callit@gmail.com");
        dept.agregarEmpleado(e1);
        dept.agregarEmpleado(e2);

        reunion.invitar(dept, Instant.parse("2039-07-04T16:00:00Z"));

        assertEquals(2, reunion.getInvitaciones().size());
        assertSame(e1, reunion.getInvitaciones().get(0).getInvitado());
        assertSame(e2, reunion.getInvitaciones().get(1).getInvitado());
    }

    @Test
    void testInvitarDepartamentoAsistencia() {
        Reunion reunion = crearReunion();
        Departamento dept = new Departamento("RRHH");
        Empleado e1 = new Empleado("2", "de Leon", "Marta", "marta@gmail.com");
        dept.agregarEmpleado(e1);

        reunion.invitar(dept, Instant.parse("2026-05-22T00:00:00Z"));
        reunion.agregarAsistencia(e1);

        assertEquals(1, reunion.obtenerAsistencias().size());
        assertSame(e1, reunion.obtenerAsistencias().get(0).getAsistente());
    }

    @Test
    void testToString() {
        Reunion reunion = crearReunion();
        reunion.agregarNota(new Nota("aura"));

        String texto = reunion.toString();
        assertTrue(texto.contains("Tipo: TECNICA"));
        assertTrue(texto.contains("Fecha: 2026-05-23"));
        assertTrue(texto.contains("aura"));
        assertTrue(texto.contains("Total invitados: 0"));
    }
}
