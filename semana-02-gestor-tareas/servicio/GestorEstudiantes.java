package servicio;

import modelo.Estudiante;
import java.util.ArrayList;

public class GestorEstudiantes {

    private ArrayList<Estudiante> estudiantes;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregar(Estudiante e) {
        estudiantes.add(e);
    }

    public void listar() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes");
            return;
        }

        for (Estudiante e : estudiantes) {
            e.mostrarInfo();
        }
    }

    public Estudiante buscar(String carnet) {
        for (Estudiante e : estudiantes) {
            if (e.getCarnet().equals(carnet)) {
                return e;
            }
        }
        return null;
    }

    public void eliminar(String carnet) {
        Estudiante e = buscar(carnet);

        if (e != null) {
            estudiantes.remove(e);
            System.out.println("Estudiante eliminado");
        } else {
            System.out.println("No encontrado");
        }
    }

    public int total() {
        return estudiantes.size();
    }
}