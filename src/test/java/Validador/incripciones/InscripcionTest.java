package Validador.incripciones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    Materia discreta = new Materia("Discreta", List.of());
    Materia paradigmas = new Materia("Paradigmas", List.of(discreta));
    Alumno pepe = new Alumno("1777771");


    @Test
    @DisplayName("Test para agregar las materias aprobadas al alumno")
    void aprobo_materia() {
        pepe.aprobo(discreta);
        pepe.aprobo(paradigmas);

        Assertions.assertEquals(List.of(discreta,paradigmas), pepe.getAprobada());
    }

    @Test
    @DisplayName("Test para desmentir que cumple correlativa")
    void no_cumple_correlatividad() {

        Materia sistemasyOrganizaciones = new Materia("Sistemas y Organizaciones", List.of());
        Materia analisisDeSistemas = new Materia("Analisis de Sistemas", List.of(sistemasyOrganizaciones));
        Materia disenio = new Materia("Diseño de Sistemas", List.of(paradigmas,analisisDeSistemas ));

        pepe.aprobo(discreta);
        pepe.aprobo(paradigmas);

        Assertions.assertFalse(pepe.cumpleCorrelatividad(disenio.getCorrelativas()));
    }

    @Test
    @DisplayName("Test para verificar que cumple correlativa")
    void cumple_correlatividad() {
        Materia sistemasyOrganizaciones = new Materia("Sistemas y Organizaciones", List.of());
        Materia analisisDeSistemas = new Materia("Analisis de Sistemas", List.of(sistemasyOrganizaciones));
        Materia disenio = new Materia("Diseño de Sistemas", List.of(paradigmas,analisisDeSistemas ));

        pepe.aprobo(discreta);
        pepe.aprobo(paradigmas);
        pepe.aprobo(sistemasyOrganizaciones);
        pepe.aprobo(analisisDeSistemas);

        Assertions.assertTrue(pepe.cumpleCorrelatividad(disenio.getCorrelativas()));
    }

    @Test
    @DisplayName("Test para rechazar la inscripcion de pepe")
    void rechazar_inscripcion() {
        Materia sistemasyOrganizaciones = new Materia("Sistemas y Organizaciones", List.of());
        Materia analisisDeSistemas = new Materia("Analisis de Sistemas", List.of(sistemasyOrganizaciones));
        Materia disenio = new Materia("Diseño de Sistemas", List.of(paradigmas,analisisDeSistemas ));
        Inscripcion opcion1 = new Inscripcion(List.of(disenio),pepe);

        pepe.aprobo(discreta);
        pepe.aprobo(paradigmas);
        pepe.aprobo(sistemasyOrganizaciones);

        Assertions.assertFalse(opcion1.aprobada());

    }

    @Test
    @DisplayName("Test para aprobar la inscripcion de pepe")
    void aceptar_inscripcion() {
        Materia sistemasyOrganizaciones = new Materia("Sistemas y Organizaciones", List.of());
        Materia analisisDeSistemas = new Materia("Analisis de Sistemas", List.of(sistemasyOrganizaciones));
        Materia disenio = new Materia("Diseño de Sistemas", List.of(paradigmas,analisisDeSistemas ));
        Inscripcion opcion1 = new Inscripcion(List.of(disenio),pepe);

        pepe.aprobo(discreta);
        pepe.aprobo(paradigmas);
        pepe.aprobo(sistemasyOrganizaciones);
        pepe.aprobo(analisisDeSistemas);

        Assertions.assertTrue(opcion1.aprobada());

    }

}