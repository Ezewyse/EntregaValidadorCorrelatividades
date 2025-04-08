package Validador.incripciones;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String legajo;
    private List<Materia> aprobadas;

    public Alumno(String legajo) {
        this.legajo = legajo;
        this.aprobadas = new ArrayList<Materia>();
    }

    public void aprobo(Materia aprobada) {
        this.aprobadas.add(aprobada);
    }
    public List<Materia> getMateriasAprobadas() {
        return aprobadas;
    }
    public Boolean cumpleCorrelatividad(List<Materia> correlativas) {
        return this.aprobadas.containsAll(correlativas);
    }

}
