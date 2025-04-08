package Validador.incripciones;

import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion {
    private List<Materia> materias_inscripcion;
    private Alumno alumno;

    public Inscripcion(List<Materia> materias_inscripcion, Alumno alumno) {
        this.materias_inscripcion = materias_inscripcion;
        this.alumno = alumno;
    }

    public Boolean aprobada() {
        List<Materia> materias_correlativas = materias_inscripcion.stream()
                        .flatMap(materia -> materia.getCorrelativas().stream()).collect(Collectors.toList());
        return alumno.cumpleCorrelatividad(materias_correlativas);
    }
}
