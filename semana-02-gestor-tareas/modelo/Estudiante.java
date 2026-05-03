package semana-02-gestor-tareas.modelo;

public class Estudiante {

    private String nombre;
    private String carnet;
    private double promedio;

    public Estudiante(String nombre, String carnet, double promedio) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public double getPromedio() {
        return promedio;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Carnet: " + carnet);
        System.out.println("Promedio: " + promedio);
    }

    public boolean estaAprobado() {
        return promedio >= 51;
    }
}
```
