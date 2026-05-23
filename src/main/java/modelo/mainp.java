package modelo;

import java.time.*;

public class mainp {
    public static void main(String[] args) {
        var e=new Empleado("1", "so", "que", "queso@gmail.com");
        var e2=new Empleado("2", "Pearl", "Tom", "tpearl@gmail.com");
        var e3=new Empleado("3","Williams","Ash", "awilliams@gmail.com");

        var rp=new ReunionPresencial(LocalDate.now(), Instant.now(), Duration.ofMinutes(180), e, tipoReunion.MARKETING, "512");
        rp.invitar(e2, Instant.now());
        rp.invitar(e3, Instant.now());
        rp.agregarAsistencia(e3);
        rp.agregarNota(new Nota("Hola mundillo"));
        rp.agregarNota(new Nota("jelo guorl"));
        System.out.println(rp);
    }
}
