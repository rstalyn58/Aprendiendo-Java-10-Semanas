import servicio.GestorContactos;
import modelo.Contacto;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestorContactos gestor = new GestorContactos("datos/contactos.json");

        int opcion;

        do {
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    gestor.agregar(new Contacto(nombre, telefono, email));
                    System.out.println("Contacto agregado");
                    break;

                case 2:
                    List<Contacto> contactos = gestor.listar();

                    if (contactos.isEmpty()) {
                        System.out.println("No hay contactos");
                    } else {
                        contactos.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    Contacto encontrado = gestor.buscar(nombreBuscar);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;

                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    boolean eliminado = gestor.eliminar(nombreEliminar);

                    if (eliminado) {
                        System.out.println("Contacto eliminado");
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        scanner.close();
    }
}